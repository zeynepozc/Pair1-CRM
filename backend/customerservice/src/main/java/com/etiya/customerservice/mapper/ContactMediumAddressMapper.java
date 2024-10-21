package com.etiya.customerservice.mapper;

import com.etiya.customerservice.entity.ContactMediumAddress;
import com.etiya.customerservice.service.dto.request.contactMediumAddress.CreateContactMediumAddressRequestDto;
import com.etiya.customerservice.service.dto.request.contactMediumAddress.UpdateContactMediumAddressRequestDto;
import com.etiya.customerservice.service.dto.response.contactMediumAddress.CreateContactMediumAddressResponseDto;
import com.etiya.customerservice.service.dto.response.contactMediumAddress.GetByIdContactMediumAddressResponseDto;
import com.etiya.customerservice.service.dto.response.contactMediumAddress.ListContactMediumAddressResponseDto;
import com.etiya.customerservice.service.dto.response.contactMediumAddress.UpdateContactMediumAddressResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public abstract class ContactMediumAddressMapper {
    @Mapping(source="contactMediumId", target = "contactMedium.id")
    @Mapping(source="contactAddressId", target = "contactAddress.id")
    public abstract ContactMediumAddress contactMediumAddressFromCreateContactMediumAddressRequestDto(CreateContactMediumAddressRequestDto dto);

    @Mapping(source="contactMediumId", target = "contactMedium.id")
    @Mapping(source="contactAddressId", target = "contactAddress.id")
    public abstract ContactMediumAddress contactMediumAddressFromUpdateContactMediumAddressRequestDto(UpdateContactMediumAddressRequestDto dto);

    @Mapping(source="contactMedium.id", target = "contactMediumId")
    @Mapping(source="contactAddress.id", target = "contactAddressId")
    public abstract CreateContactMediumAddressResponseDto createContactMediumAddressResponseDtoFromContactMediumAddress(ContactMediumAddress contactMediumAddress);

    @Mapping(source="contactMedium.id", target = "contactMediumId")
    @Mapping(source="contactAddress.id", target = "contactAddressId")
    public abstract GetByIdContactMediumAddressResponseDto getByIdContactMediumAddressResponseDtoFromContactMediumAddress(ContactMediumAddress contactMediumAddress);

    @Mapping(source="contactMedium.id", target = "contactMediumId")
    @Mapping(source="contactAddress.id", target = "contactAddressId")
    public abstract UpdateContactMediumAddressResponseDto updateContactMediumAddressResponseDtoFromContactMediumAddress(ContactMediumAddress contactMediumAddress);

    @Mapping(source="contactMedium.id", target = "contactMediumId")
    @Mapping(source="contactAddress.id", target = "contactAddressId")
    public abstract List<ListContactMediumAddressResponseDto> listContactMediumAddressResponseDtoListFromContactMediumAddressList(List<ContactMediumAddress> contactMediumAddress);

    @Mapping(source="contactMedium.id", target = "contactMediumId")
    @Mapping(source="contactAddress.id", target = "contactAddressId")
    public abstract ListContactMediumAddressResponseDto contactMediumAddressToListContactMediumAddressResponseDto(ContactMediumAddress contactMediumAddress);
}
