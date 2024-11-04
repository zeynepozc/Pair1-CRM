package com.etiya.customerservice.service.concrete;

import com.etiya.customerservice.entity.CustomerAccount;
import com.etiya.customerservice.mapper.CustomerAccountMapper;
import com.etiya.customerservice.repository.CustomerAccountRepository;
import com.etiya.customerservice.service.abstracts.CustomerAccountService;
import com.etiya.customerservice.service.abstracts.BillingAccountService;
import com.etiya.customerservice.service.dto.request.billingAccount.CreateBillingAccountRequestDto;
import com.etiya.customerservice.service.dto.request.customerAccount.CreateCustomerAccountRequestDto;
import com.etiya.customerservice.service.dto.request.customerAccount.UpdateCustomerAccountRequestDto;
import com.etiya.customerservice.service.dto.response.customerAccount.CreateCustomerAccountResponseDto;
import com.etiya.customerservice.service.dto.response.customerAccount.GetByIdCustomerAccountResponseDto;
import com.etiya.customerservice.service.dto.response.customerAccount.ListCustomerAccountResponseDto;
import com.etiya.customerservice.service.dto.response.customerAccount.UpdateCustomerAccountResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerAccountServiceImpl implements CustomerAccountService {
    private final CustomerAccountRepository customerAccountRepository;
    private final CustomerAccountMapper customerAccountMapper;
    private final BillingAccountService billingAccountService;


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
