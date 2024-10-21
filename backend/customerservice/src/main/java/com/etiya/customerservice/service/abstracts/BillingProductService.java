package com.etiya.customerservice.service.abstracts;

import com.etiya.customerservice.service.dto.request.billingProduct.CreateBillingProductRequestDto;
import com.etiya.customerservice.service.dto.response.billingProduct.CreateBillingProductResponseDto;
import com.etiya.customerservice.service.dto.response.billingProduct.GetByIdBillingProductResponseDto;
import com.etiya.customerservice.service.dto.response.billingProduct.ListBillingProductResponseDto;

import java.util.List;

public interface BillingProductService {
    List<ListBillingProductResponseDto> getAll();
    GetByIdBillingProductResponseDto getById(Long id);
    CreateBillingProductResponseDto add(CreateBillingProductRequestDto dto);
    void delete(Long id);
}
