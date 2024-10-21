package com.etiya.customerservice.mapper;


import com.etiya.customerservice.entity.ContactMedium;
import com.etiya.customerservice.service.dto.request.contactMedium.CreateContactMediumRequestDto;
import com.etiya.customerservice.service.dto.request.contactMedium.UpdateContactMediumRequestDto;
import com.etiya.customerservice.service.dto.response.contactMedium.CreateContactMediumResponseDto;
import com.etiya.customerservice.service.dto.response.contactMedium.GetByIdContactMediumResponseDto;
import com.etiya.customerservice.service.dto.response.contactMedium.ListContactMediumResponseDto;
import com.etiya.customerservice.service.dto.response.contactMedium.UpdateContactMediumResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public abstract class ContactMediumMapper {
    @Mapping(source = "customerId", target = "customer.id")
    public abstract ContactMedium contactMediumFromCreateContactMediumRequestDto(CreateContactMediumRequestDto dto);

    @Mapping(source = "customerId", target = "customer.id")
    public abstract ContactMedium contactMediumFromUpdateContactMediumRequestDto(UpdateContactMediumRequestDto dto);

    @Mapping(source = "customer.id", target = "customerId")
    public abstract CreateContactMediumResponseDto createContactMediumResponseDtoFromContactMedium(ContactMedium contactMedium);

    @Mapping(source = "customer.id", target = "customerId")
    public abstract GetByIdContactMediumResponseDto getByIdContactMediumResponseDtoFromContactMedium(ContactMedium contactMedium);

    @Mapping(source = "customer.id", target = "customerId")
    public abstract UpdateContactMediumResponseDto updateContactMediumResponseDtoFromContactMedium(ContactMedium contactMedium);

    @Mapping(source = "customer.id", target = "customerId")
    public abstract List<ListContactMediumResponseDto> listContactMediumResponseDtoListFromContactMediumList(List<ContactMedium> contactMediumList);
    @Mapping(source = "customer.id", target = "customerId")
    public abstract ListContactMediumResponseDto contactMediumToContactMediumResponseDto(ContactMedium contactMedium);

}
