package com.etiya.customerservice.mapper;

import com.etiya.customerservice.entity.IndividualCustomer;
import com.etiya.customerservice.service.dto.request.individualCustomer.CreateIndividualCustomerRequestDto;
import com.etiya.customerservice.service.dto.request.individualCustomer.UpdateIndividualCustomerRequestDto;
import com.etiya.customerservice.service.dto.response.individualCustomer.CreateIndividualCustomerResponseDto;
import com.etiya.customerservice.service.dto.response.individualCustomer.GetByIdIndividualCustomerResponseDto;
import com.etiya.customerservice.service.dto.response.individualCustomer.ListIndividualCustomerResponseDto;
import com.etiya.customerservice.service.dto.response.individualCustomer.UpdateIndividualCustomerResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public abstract class IndividualCustomerMapper {
    public abstract IndividualCustomer individualCustomerFromCreateIndividualCustomerRequestDto(CreateIndividualCustomerRequestDto dto);

    public abstract IndividualCustomer individualCustomerFromUpdateIndividualCustomerRequestDto(UpdateIndividualCustomerRequestDto dto);

    public abstract CreateIndividualCustomerResponseDto createIndividualCustomerResponseDtoFromIndividualCustomer(IndividualCustomer individualCustomer);

    public abstract GetByIdIndividualCustomerResponseDto getByIdIndividualCustomerResponseDtoFromIndividualCustomer(IndividualCustomer individualCustomer);

    public abstract UpdateIndividualCustomerResponseDto updateIndividualCustomerResponseDtoFromIndividualCustomer(IndividualCustomer individualCustomer);

    public abstract List<ListIndividualCustomerResponseDto> listIndividualCustomerResponseDtoListFromIndividualCustomerList(List<IndividualCustomer> individualCustomerList);

    public abstract ListIndividualCustomerResponseDto individualCustomerToIndividualCustomerResponseDto(IndividualCustomer individualCustomer);

}