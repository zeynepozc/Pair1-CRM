package com.etiya.customerservice.service.abstracts;

import com.etiya.customerservice.service.dto.request.individualCustomer.CreateIndividualCustomerRequestDto;
import com.etiya.customerservice.service.dto.request.individualCustomer.UpdateIndividualCustomerRequestDto;
import com.etiya.customerservice.service.dto.response.individualCustomer.CreateIndividualCustomerResponseDto;
import com.etiya.customerservice.service.dto.response.individualCustomer.GetByIdIndividualCustomerResponseDto;
import com.etiya.customerservice.service.dto.response.individualCustomer.ListIndividualCustomerResponseDto;
import com.etiya.customerservice.service.dto.response.individualCustomer.UpdateIndividualCustomerResponseDto;

import java.util.List;

public interface IndividualCustomerService {

    List<ListIndividualCustomerResponseDto> getAll();
    GetByIdIndividualCustomerResponseDto getById(Long id);
    CreateIndividualCustomerResponseDto add(CreateIndividualCustomerRequestDto dto);
    UpdateIndividualCustomerResponseDto update(UpdateIndividualCustomerRequestDto dto);
    void delete(Long id);
}
