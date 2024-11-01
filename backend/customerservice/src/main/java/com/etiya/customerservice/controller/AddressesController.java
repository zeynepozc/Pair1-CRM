package com.etiya.customerservice.controller;

import com.etiya.customerservice.service.abstracts.AddressService;
import com.etiya.customerservice.service.dto.request.address.CreateAddressRequestDto;
import com.etiya.customerservice.service.dto.response.address.CreateAddressResponseDto;
import com.etiya.customerservice.service.dto.response.contactAddress.CreateContactAddressResponseDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/api/addresses")
@RequiredArgsConstructor
public class AddressesController {
    private final AddressService addressService;

    @PostMapping
    public ResponseEntity<CreateAddressResponseDto> add(@RequestBody @Valid CreateAddressRequestDto createAddressRequestDto){
        CreateAddressResponseDto createAddressResponseDto = addressService.add(createAddressRequestDto);

        if (createAddressResponseDto != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(createAddressResponseDto);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }


}
