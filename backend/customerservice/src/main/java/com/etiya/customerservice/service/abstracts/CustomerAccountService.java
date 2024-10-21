package com.etiya.customerservice.service.abstracts;

import com.etiya.customerservice.service.dto.request.customerAccount.CreateCustomerAccountRequestDto;
import com.etiya.customerservice.service.dto.request.customerAccount.UpdateCustomerAccountRequestDto;
import com.etiya.customerservice.service.dto.response.customerAccount.CreateCustomerAccountResponseDto;
import com.etiya.customerservice.service.dto.response.customerAccount.GetByIdCustomerAccountResponseDto;
import com.etiya.customerservice.service.dto.response.customerAccount.ListCustomerAccountResponseDto;
import com.etiya.customerservice.service.dto.response.customerAccount.UpdateCustomerAccountResponseDto;

import java.util.List;

public interface CustomerAccountService {
    List<ListCustomerAccountResponseDto> getAll();
    GetByIdCustomerAccountResponseDto getById(Long id);

    CreateCustomerAccountResponseDto add(CreateCustomerAccountRequestDto customerAccountRequestDto);

    UpdateCustomerAccountResponseDto update(UpdateCustomerAccountRequestDto updateCustomerAccountRequestDto);

    void delete(Long id);
}
