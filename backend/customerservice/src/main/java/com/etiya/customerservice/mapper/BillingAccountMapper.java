package com.etiya.customerservice.mapper;

import com.etiya.customerservice.entity.BillingAccount;
import com.etiya.customerservice.service.dto.request.billingAccount.CreateBillingAccountRequestDto;
import com.etiya.customerservice.service.dto.request.billingAccount.UpdateBillingAccountRequestDto;
import com.etiya.customerservice.service.dto.response.billingAccount.CreateBillingAccountResponseDto;
import com.etiya.customerservice.service.dto.response.billingAccount.GetByIdBillingAccountResponseDto;
import com.etiya.customerservice.service.dto.response.billingAccount.ListBillingAccountResponseDto;
import com.etiya.customerservice.service.dto.response.billingAccount.UpdateBillingAccountResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public abstract class BillingAccountMapper {

    @Mapping(source="customerAccountId", target = "customerAccount.id")
    public abstract BillingAccount billingAccountFromCreateBillingAccountRequestDto(CreateBillingAccountRequestDto dto);

    @Mapping(source="customerAccountId", target = "customerAccount.id")
    public abstract BillingAccount billingAccountFromUpdateBillingAccountRequestDto(UpdateBillingAccountRequestDto dto);

    @Mapping(source="customerAccount.id", target = "customerAccountId")
    public abstract CreateBillingAccountResponseDto createBillingAccountResponseDtoFromBillingAccount(BillingAccount billingAccount);

    @Mapping(source="customerAccount.id", target = "customerAccountId")
    public abstract GetByIdBillingAccountResponseDto getByIdBillingAccountResponseDtoFromBillingAccount(BillingAccount billingAccount);

    @Mapping(source="customerAccount.id", target = "customerAccountId")
    public abstract UpdateBillingAccountResponseDto updateBillingAccountResponseDtoFromBillingAccount(BillingAccount billingAccount);

    @Mapping(source="customerAccount.id", target = "customerAccountId")
    public abstract List<ListBillingAccountResponseDto> listBillingAccountResponseDtoListFromBillingAccountList(List<BillingAccount> billingAccount);

    @Mapping(source="customerAccount.id", target = "customerAccountId")
    public abstract ListBillingAccountResponseDto billingAccountToListBillingAccountResponseDto(BillingAccount billingAccount);
}
