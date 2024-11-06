package com.etiya.customerservice.controller;

import com.etiya.customerservice.service.abstracts.AddressService;
import com.etiya.customerservice.service.dto.request.address.CreateAddressRequestDto;
import com.etiya.customerservice.service.dto.response.address.CreateAddressResponseDto;
import com.etiya.customerservice.service.dto.response.address.GetByIdAddressResponseDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/{id}")
    public ResponseEntity<List<GetByIdAddressResponseDto>> getById(@PathVariable Long id){
        List<GetByIdAddressResponseDto> addressResponseDto = addressService.getById(id);

        return ResponseEntity.status(HttpStatus.OK).body(addressResponseDto);
    }


}
