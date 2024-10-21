package com.etiya.customerservice.service.abstracts;

import com.etiya.customerservice.service.dto.request.corporateCustomer.CreateCorporateCustomerRequestDto;
import com.etiya.customerservice.service.dto.request.corporateCustomer.UpdateCorporateCustomerRequestDto;
import com.etiya.customerservice.service.dto.response.corporateCustomer.CreateCorporateCustomerResponseDto;
import com.etiya.customerservice.service.dto.response.corporateCustomer.GetByIdCorporateCustomerResponseDto;
import com.etiya.customerservice.service.dto.response.corporateCustomer.ListCorporateCustomerResponseDto;
import com.etiya.customerservice.service.dto.response.corporateCustomer.UpdateCorporateCustomerResponseDto;

import java.util.List;

public interface CorporateCustomerService {
    List<ListCorporateCustomerResponseDto> getAll();
    GetByIdCorporateCustomerResponseDto getById(Long id);
    CreateCorporateCustomerResponseDto add(CreateCorporateCustomerRequestDto dto);
    UpdateCorporateCustomerResponseDto update(UpdateCorporateCustomerRequestDto dto);
    void delete(Long id);
}
