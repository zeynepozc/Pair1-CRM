package com.etiya.customerservice.service.abstracts;

import com.etiya.customerservice.service.dto.request.customerAccount.CreateCustomerAccountRequestDto;
import com.etiya.customerservice.service.dto.request.customerAccount.UpdateCustomerAccountRequestDto;
import com.etiya.customerservice.service.dto.response.customerAccount.*;

import java.util.List;

public interface CustomerAccountService {
    List<ListCustomerAccountResponseDto> getAll();

    List<ListCustomerAccountWithProductsResponseDto> getAllByCustomerId(Long id);
    GetByIdCustomerAccountResponseDto getById(Long id);

    CreateCustomerAccountResponseDto addCustomerAccountAndBillingAccount(CreateCustomerAccountRequestDto customerAccountRequestDto);

    CustomerAccountProductListResponseDto getProductsByCustomerAccountId(Long customerAccountId);
    CreateCustomerAccountResponseDto add(CreateCustomerAccountRequestDto customerAccountRequestDto);

    UpdateCustomerAccountResponseDto update(UpdateCustomerAccountRequestDto updateCustomerAccountRequestDto);

    void delete(Long id);
}
