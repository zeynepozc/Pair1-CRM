package com.etiya.customerservice.service.abstracts;

import com.etiya.customerservice.service.dto.request.address.CreateAddressRequestDto;
import com.etiya.customerservice.service.dto.response.address.CreateAddressResponseDto;

public interface AddressService {
    CreateAddressResponseDto addAddress(CreateAddressRequestDto dto);
}
