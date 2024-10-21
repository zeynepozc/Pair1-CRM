package com.etiya.customerservice.service.abstracts;

import com.etiya.customerservice.service.dto.request.billingAccount.CreateBillingAccountRequestDto;
import com.etiya.customerservice.service.dto.request.billingAccount.UpdateBillingAccountRequestDto;
import com.etiya.customerservice.service.dto.response.billingAccount.CreateBillingAccountResponseDto;
import com.etiya.customerservice.service.dto.response.billingAccount.GetByIdBillingAccountResponseDto;
import com.etiya.customerservice.service.dto.response.billingAccount.ListBillingAccountResponseDto;
import com.etiya.customerservice.service.dto.response.billingAccount.UpdateBillingAccountResponseDto;

import java.util.List;

public interface BillingAccountService {
    List<ListBillingAccountResponseDto> getAll();
    GetByIdBillingAccountResponseDto getById(Long id);
    CreateBillingAccountResponseDto add(CreateBillingAccountRequestDto dto);
    UpdateBillingAccountResponseDto update(UpdateBillingAccountRequestDto dto);
    void delete(Long id);
}
