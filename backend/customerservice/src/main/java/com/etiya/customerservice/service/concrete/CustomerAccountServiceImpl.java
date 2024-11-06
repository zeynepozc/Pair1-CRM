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


import com.etiya.event.ProductsCalledEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.stream.function.StreamBridge;
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
    private final StreamBridge streamBridge;


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

    @Override
    public List<ListCustomerAccountWithProductsResponseDto> getAllByCustomerId(Long id) {
        List<CustomerAccount> customerAccountList = customerAccountRepository.getCustomerAccountsByCustomer_Id(id);

        return customerAccountList.stream()
                .map(customerAccount -> {
                    BillingAccount billingAccount = billingAccountService.getBillingAccountById(customerAccount.getId()).orElse(null);
                    if (billingAccount == null) {
                        return null;
                    }

                    List<BillingProduct> billingProductList = billingProductService.findBillingProductsByBillingAccountId(billingAccount.getId());
                    List<Product> products = new ArrayList<>();

                    billingProductList.forEach(_billingProduct -> {
                        List<Long> productIdList = _billingProduct.getProductIdList();
                        products.addAll(productServiceClient.findAllByIds(productIdList));
                        ProductsCalledEvent productsCalledEvent = new ProductsCalledEvent();
                        productsCalledEvent.setId(id);
                        streamBridge.send("productsCalledEvent-out-0", productsCalledEvent);
                    });

                    return new ListCustomerAccountWithProductsResponseDto(
                            customerAccount.getCustomer().getId(),
                            customerAccount.getAccountStatus(),
                            customerAccount.getAccountNumber(),
                            customerAccount.getAccountName(),
                            customerAccount.getAccountType(),
                            customerAccount.getAccountDescription(),
                            products
                    );
                })
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    @Override
    public CustomerAccountProductListResponseDto getProductsByCustomerAccountId(Long customerAccountId) {
        CustomerAccount customerAccount = customerAccountRepository.findById(customerAccountId).orElse(null);

        if (customerAccount == null) {
            return null;
        }

        BillingAccount billingAccount = billingAccountService.getBillingAccountById(customerAccount.getId()).orElse(null);

        if (billingAccount == null) {
            return null;
        }

        List<BillingProduct> billingProductList = billingProductService.findBillingProductsByBillingAccountId(billingAccount.getId());
        List<Product> products = new ArrayList<>();

        billingProductList.forEach(_billingProduct -> {
            List<Long> productIdList = _billingProduct.getProductIdList();
            products.addAll(productServiceClient.findAllByIds(productIdList)); // Ürünleri products listesine ekle
        });

        return new CustomerAccountProductListResponseDto(
                products
        );
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
