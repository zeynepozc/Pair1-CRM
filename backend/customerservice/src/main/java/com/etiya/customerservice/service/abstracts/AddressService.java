package com.etiya.customerservice.service.abstracts;

import com.etiya.customerservice.service.dto.request.address.CreateAddressRequestDto;
import com.etiya.customerservice.service.dto.response.address.CreateAddressResponseDto;
import com.etiya.customerservice.service.dto.response.address.GetByIdAddressResponseDto;

import java.util.List;
public interface AddressService {
    CreateAddressResponseDto add(CreateAddressRequestDto dto);

    List<GetByIdAddressResponseDto> getById(Long id);

}
