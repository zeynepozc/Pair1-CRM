package com.etiya.customerservice.service.abstracts;

import com.etiya.customerservice.entity.BillingAccount;
import com.etiya.customerservice.service.dto.request.billingAccount.CreateBillingAccountRequestDto;
import com.etiya.customerservice.service.dto.request.billingAccount.UpdateBillingAccountRequestDto;
import com.etiya.customerservice.service.dto.response.billingAccount.CreateBillingAccountResponseDto;
import com.etiya.customerservice.service.dto.response.billingAccount.GetByIdBillingAccountResponseDto;
import com.etiya.customerservice.service.dto.response.billingAccount.ListBillingAccountResponseDto;
import com.etiya.customerservice.service.dto.response.billingAccount.UpdateBillingAccountResponseDto;

import java.util.List;
import java.util.Optional;

public interface BillingAccountService {
    List<ListBillingAccountResponseDto> getAll();
    GetByIdBillingAccountResponseDto getById(Long id);
    Optional<BillingAccount> getBillingAccountById(Long id);
    CreateBillingAccountResponseDto add(CreateBillingAccountRequestDto dto);
    UpdateBillingAccountResponseDto update(UpdateBillingAccountRequestDto dto);
    void delete(Long id);
}
