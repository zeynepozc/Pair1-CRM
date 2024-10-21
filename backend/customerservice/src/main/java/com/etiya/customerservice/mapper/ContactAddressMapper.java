package com.etiya.customerservice.mapper;

import com.etiya.customerservice.entity.ContactAddress;
import com.etiya.customerservice.service.dto.request.contactAddress.CreateContactAddressRequestDto;
import com.etiya.customerservice.service.dto.request.contactAddress.UpdateContactAddressRequestDto;
import com.etiya.customerservice.service.dto.response.contactAddress.CreateContactAddressResponseDto;
import com.etiya.customerservice.service.dto.response.contactAddress.GetByIdContactAddressResponseDto;
import com.etiya.customerservice.service.dto.response.contactAddress.ListContactAddressResponseDto;
import com.etiya.customerservice.service.dto.response.contactAddress.UpdateContactAddressResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public abstract class ContactAddressMapper {
    @Mapping(source = "neighborhoodId", target = "neighborhood.id")
    public abstract ContactAddress contactAddressFromCreateContactAddressRequestDto(CreateContactAddressRequestDto dto);

    @Mapping(source = "neighborhoodId", target = "neighborhood.id")
    public abstract ContactAddress contactAddressFromUpdateContactAddressRequestDto(UpdateContactAddressRequestDto dto);

    @Mapping(source = "neighborhood.id", target = "neighborhoodId")
    public abstract CreateContactAddressResponseDto createContactAddressResponseDtoFromContactAddress(ContactAddress contactAddress);

    @Mapping(source = "neighborhood.id", target = "neighborhoodId")
    public abstract GetByIdContactAddressResponseDto getByIdContactAddressResponseDtoFromContactAddress(ContactAddress contactAddress);

    @Mapping(source = "neighborhood.id", target = "neighborhoodId")
    public abstract UpdateContactAddressResponseDto updateContactAddressResponseDtoFromContactAddress(ContactAddress contactAddress);

    @Mapping(source = "neighborhood.id", target = "neighborhoodId")
    public abstract List<ListContactAddressResponseDto> listContactAddressResponseDtoListFromContactAddressList(List<ContactAddress> contactAddressList);
    @Mapping(source = "neighborhood.id", target = "neighborhoodId")
    public abstract ListContactAddressResponseDto contactAddressToContactAddressResponseDto(ContactAddress contactAddress);

}
