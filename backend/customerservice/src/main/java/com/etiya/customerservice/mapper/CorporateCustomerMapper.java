package com.etiya.customerservice.mapper;

import com.etiya.customerservice.entity.CorporateCustomer;
import com.etiya.customerservice.service.dto.request.corporateCustomer.CreateCorporateCustomerRequestDto;
import com.etiya.customerservice.service.dto.request.corporateCustomer.UpdateCorporateCustomerRequestDto;
import com.etiya.customerservice.service.dto.response.corporateCustomer.CreateCorporateCustomerResponseDto;
import com.etiya.customerservice.service.dto.response.corporateCustomer.GetByIdCorporateCustomerResponseDto;
import com.etiya.customerservice.service.dto.response.corporateCustomer.ListCorporateCustomerResponseDto;
import com.etiya.customerservice.service.dto.response.corporateCustomer.UpdateCorporateCustomerResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public abstract class CorporateCustomerMapper {
    public abstract CorporateCustomer corporateCustomerFromCreateCorporateCustomerRequestDto(CreateCorporateCustomerRequestDto dto);


    public abstract CorporateCustomer corporateCustomerFromUpdateCorporateCustomerRequestDto(UpdateCorporateCustomerRequestDto dto);

    public abstract CreateCorporateCustomerResponseDto createCorporateCustomerResponseDtoFromCorporateCustomer(CorporateCustomer corporateCustomer);

    public abstract GetByIdCorporateCustomerResponseDto getByIdCorporateCustomerResponseDtoFromCorporateCustomer(CorporateCustomer corporateCustomer);

    public abstract UpdateCorporateCustomerResponseDto updateCorporateCustomerResponseDtoFromCorporateCustomer(CorporateCustomer corporateCustomer);

    public abstract List<ListCorporateCustomerResponseDto> listCorporateCustomerResponseDtoListFromCorporateCustomerList(List<CorporateCustomer> corporateCustomerList);
    public abstract ListCorporateCustomerResponseDto corporateCustomerToCorporateCustomerResponseDto(CorporateCustomer corporateCustomer);


}