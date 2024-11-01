package com.etiya.customerservice.service.abstracts;

import com.etiya.customerservice.service.dto.request.address.CreateAddressRequestDto;
import com.etiya.customerservice.service.dto.response.address.CreateAddressResponseDto;
import com.etiya.customerservice.service.dto.response.contactAddress.CreateContactAddressResponseDto;

public interface AddressService {
    CreateContactAddressResponseDto add(CreateAddressRequestDto dto);
}
