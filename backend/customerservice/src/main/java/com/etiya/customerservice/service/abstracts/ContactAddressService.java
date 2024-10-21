package com.etiya.customerservice.service.abstracts;

import com.etiya.customerservice.service.dto.request.contactAddress.CreateContactAddressRequestDto;
import com.etiya.customerservice.service.dto.request.contactAddress.UpdateContactAddressRequestDto;
import com.etiya.customerservice.service.dto.response.contactAddress.CreateContactAddressResponseDto;
import com.etiya.customerservice.service.dto.response.contactAddress.GetByIdContactAddressResponseDto;
import com.etiya.customerservice.service.dto.response.contactAddress.ListContactAddressResponseDto;
import com.etiya.customerservice.service.dto.response.contactAddress.UpdateContactAddressResponseDto;

import java.util.List;

public interface ContactAddressService {

    List<ListContactAddressResponseDto> getAll();
    GetByIdContactAddressResponseDto getById(Long id);
    CreateContactAddressResponseDto add(CreateContactAddressRequestDto dto);
    UpdateContactAddressResponseDto update(UpdateContactAddressRequestDto dto);
    void delete(Long id);
}
