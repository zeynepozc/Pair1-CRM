package com.etiya.customerservice.mapper;

import com.etiya.customerservice.entity.CustomerAccount;
import com.etiya.customerservice.service.dto.request.customerAccount.CreateCustomerAccountRequestDto;
import com.etiya.customerservice.service.dto.request.customerAccount.UpdateCustomerAccountRequestDto;
import com.etiya.customerservice.service.dto.response.customerAccount.CreateCustomerAccountResponseDto;
import com.etiya.customerservice.service.dto.response.customerAccount.GetByIdCustomerAccountResponseDto;
import com.etiya.customerservice.service.dto.response.customerAccount.ListCustomerAccountResponseDto;
import com.etiya.customerservice.service.dto.response.customerAccount.UpdateCustomerAccountResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;


import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public abstract class CustomerAccountMapper {
    @Mapping(source = "customerId", target = "customerId.id")
    public abstract CustomerAccount customerAccountFromCreateCustomerAccountRequestDto(CreateCustomerAccountRequestDto dto);

    @Mapping(source = "customerId", target = "customerId.id")
    public abstract CustomerAccount customerAccountFromUpdateCustomerAccountRequestDto(UpdateCustomerAccountRequestDto dto);

    @Mapping(source = "customerId.id", target = "customerId")
    public abstract CreateCustomerAccountResponseDto createCustomerAccountResponseDtoFromCustomerAccount(CustomerAccount customerAccount);

    @Mapping(source = "customerId.id", target = "customerId")
    public abstract GetByIdCustomerAccountResponseDto getByIdCustomerAccountResponseDtoFromCustomerAccount(CustomerAccount customerAccount);

    @Mapping(source = "customerId.id", target = "customerId")
    public abstract UpdateCustomerAccountResponseDto updateCustomerAccountResponseDtoFromCustomerAccount(CustomerAccount customerAccount);

    @Mapping(source = "customerId.id", target = "customerId")
    public abstract List<ListCustomerAccountResponseDto> listCustomerAccountResponseDtoListFromCustomerAccountList(List<CustomerAccount> customerAccountList);
    @Mapping(source = "customerId.id", target = "customerId")
    public abstract ListCustomerAccountResponseDto customerAccountToCustomerAccountResponseDto(CustomerAccount customerAccount);

}
