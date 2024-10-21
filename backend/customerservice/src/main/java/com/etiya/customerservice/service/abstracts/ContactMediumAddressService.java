package com.etiya.customerservice.service.abstracts;

import com.etiya.customerservice.service.dto.request.contactMediumAddress.CreateContactMediumAddressRequestDto;
import com.etiya.customerservice.service.dto.request.contactMediumAddress.UpdateContactMediumAddressRequestDto;
import com.etiya.customerservice.service.dto.response.contactMediumAddress.CreateContactMediumAddressResponseDto;
import com.etiya.customerservice.service.dto.response.contactMediumAddress.GetByIdContactMediumAddressResponseDto;
import com.etiya.customerservice.service.dto.response.contactMediumAddress.ListContactMediumAddressResponseDto;
import com.etiya.customerservice.service.dto.response.contactMediumAddress.UpdateContactMediumAddressResponseDto;

import java.util.List;

public interface ContactMediumAddressService {
    List<ListContactMediumAddressResponseDto> getAll();
    GetByIdContactMediumAddressResponseDto getById(Long id);
    CreateContactMediumAddressResponseDto add(CreateContactMediumAddressRequestDto dto);
    UpdateContactMediumAddressResponseDto update(UpdateContactMediumAddressRequestDto dto);
    void delete(Long id);
}
