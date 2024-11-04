package com.etiya.customerservice.service.concrete;

import com.etiya.customerservice.client.ProductServiceClient;
import com.etiya.customerservice.entity.BillingAccount;
import com.etiya.customerservice.entity.BillingProduct;
import com.etiya.customerservice.entity.CustomerAccount;
import com.etiya.customerservice.entity.Product;
import com.etiya.customerservice.mapper.CustomerAccountMapper;
import com.etiya.customerservice.repository.CustomerAccountRepository;
import com.etiya.customerservice.service.abstracts.BillingProductService;
import com.etiya.customerservice.service.abstracts.CustomerAccountService;
import com.etiya.customerservice.service.abstracts.BillingAccountService;
import com.etiya.customerservice.service.dto.request.billingAccount.CreateBillingAccountRequestDto;
import com.etiya.customerservice.service.dto.request.customerAccount.CreateCustomerAccountRequestDto;
import com.etiya.customerservice.service.dto.request.customerAccount.UpdateCustomerAccountRequestDto;
import com.etiya.customerservice.service.dto.response.customerAccount.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerAccountServiceImpl implements CustomerAccountService {
    private final CustomerAccountRepository customerAccountRepository;
    private final CustomerAccountMapper customerAccountMapper;
    private final BillingAccountService billingAccountService;
    private final BillingProductService billingProductService;
    private final ProductServiceClient productServiceClient;


    @Override
    public List<ListCustomerAccountResponseDto> getAll() {
        List<CustomerAccount> customerAccountList = customerAccountRepository.findAll();
        return customerAccountMapper.listCustomerAccountResponseDtoListFromCustomerAccountList(customerAccountList);
    }

    @Override
    public GetByIdCustomerAccountResponseDto getById(Long id) {
        Optional<CustomerAccount> customerAccount = customerAccountRepository.findById(id);
        return customerAccountMapper.getByIdCustomerAccountResponseDtoFromCustomerAccount(customerAccount.get());
    }
/*
    @Override
    public List<ListCustomerAccountResponseDto> getAllByCustomerId(Long id){
        List<CustomerAccount> customerAccountList = customerAccountRepository.getCustomerAccountsByCustomer_Id(id);

        customerAccountList.stream()
                .map(customerAccount -> {
                    BillingAccount billingAccount = billingAccountService.getBillingAccountById(customerAccount.getId()).get();
                    List<BillingProduct> billingProduct = billingProductService.getBillingProductById(billingAccount.getId());
                    List<Product> products = new ArrayList<>();
                    billingProduct.stream().map(
                            _billingProduct -> {
                               List<Long> productIdList =  _billingProduct.getProductIdList();
                               return products.addAll(productServiceClient.findAllByIds(productIdList));
                            }
                    )

                })
                .collect(Collectors.toList());

        return customerAccountMapper.listCustomerAccountResponseDtoListFromCustomerAccountList(customerAccountList);
    }*/

    @Override
    public List<ListCustomerAccountWithProductsResponseDto> getAllByCustomerId(Long id) {
        List<CustomerAccount> customerAccountList = customerAccountRepository.getCustomerAccountsByCustomer_Id(id);

        return customerAccountList.stream()
                .map(customerAccount -> {
                    // Faturalama hesabını al
                    BillingAccount billingAccount = billingAccountService.getBillingAccountById(customerAccount.getId()).orElse(null);

                    // Eğer faturalama hesabı yoksa, bu müşteri hesabı için geçersiz bir yanıt döndür
                    if (billingAccount == null) {
                        return null; // veya uygun bir hata yönetimi
                    }

                    // Faturalama ürünlerini al
                    List<BillingProduct> billingProductList = billingProductService.findBillingProductsByBillingAccountId(billingAccount.getId());
                    List<Product> products = new ArrayList<>();

                    // Ürünleri ekle
                    billingProductList.forEach(_billingProduct -> {
                        List<Long> productIdList = _billingProduct.getProductIdList();
                        products.addAll(productServiceClient.findAllByIds(productIdList)); // Ürünleri products listesine ekle
                    });

                    // DTO'yu oluştur
                    return new ListCustomerAccountWithProductsResponseDto(
                            customerAccount.getCustomer().getId(), // customerId
                            customerAccount.getAccountStatus(), // accountStatus
                            customerAccount.getAccountNumber(), // accountNumber
                            customerAccount.getAccountName(), // accountName
                            customerAccount.getAccountType(), // accountType
                            customerAccount.getAccountDescription(), // accountDescription
                            products // productList
                    );
                })
                .filter(Objects::nonNull) // Null olanları filtrele
                .collect(Collectors.toList());
    }

    @Override
    public CreateCustomerAccountResponseDto add(CreateCustomerAccountRequestDto createCustomerAccountRequestDto) {
        CustomerAccount customerAccount = customerAccountMapper.customerAccountFromCreateCustomerAccountRequestDto(createCustomerAccountRequestDto);
        customerAccount.setAccountNumber(generateAccountNumber());
        return customerAccountMapper.createCustomerAccountResponseDtoFromCustomerAccount(customerAccountRepository.save(customerAccount));
    }

    @Override
    public UpdateCustomerAccountResponseDto update(UpdateCustomerAccountRequestDto updateCustomerAccountRequestDto) {
        CustomerAccount customerAccount = customerAccountMapper.customerAccountFromUpdateCustomerAccountRequestDto(updateCustomerAccountRequestDto);
        customerAccount = customerAccountRepository.save(customerAccount);
        return customerAccountMapper.updateCustomerAccountResponseDtoFromCustomerAccount(customerAccount);
    }

    @Override
    public CreateCustomerAccountResponseDto addCustomerAccountAndBillingAccount(CreateCustomerAccountRequestDto customerAccountRequestDto){
        CustomerAccount customerAccount = customerAccountMapper.customerAccountFromCreateCustomerAccountRequestDto(customerAccountRequestDto);
        customerAccount.setAccountNumber(generateAccountNumber());
        customerAccount  = customerAccountRepository.save(customerAccount);
        CreateBillingAccountRequestDto billingAccountDto = new CreateBillingAccountRequestDto(customerAccount.getId(), LocalDateTime.now());
        billingAccountService.add(billingAccountDto);
        return customerAccountMapper.createCustomerAccountResponseDtoFromCustomerAccount(customerAccount);
    }


    @Override
    public void delete(Long id) {
        customerAccountRepository.deleteById(id);
    }

    private String generateAccountNumber(){
        String maxAccountNumber = customerAccountRepository.findMaxAccountNumber();
        Long newAccountNumber = Long.parseLong(maxAccountNumber) + 1;
        return String.valueOf(newAccountNumber);
    }
}
