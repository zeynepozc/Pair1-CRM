package com.etiya.customerservice.controller;

import com.etiya.customerservice.service.abstracts.ContactMediumAddressService;
import com.etiya.customerservice.service.dto.request.contactMediumAddress.CreateContactMediumAddressRequestDto;
import com.etiya.customerservice.service.dto.request.contactMediumAddress.UpdateContactMediumAddressRequestDto;
import com.etiya.customerservice.service.dto.response.contactMediumAddress.CreateContactMediumAddressResponseDto;
import com.etiya.customerservice.service.dto.response.contactMediumAddress.GetByIdContactMediumAddressResponseDto;
import com.etiya.customerservice.service.dto.response.contactMediumAddress.ListContactMediumAddressResponseDto;
import com.etiya.customerservice.service.dto.response.contactMediumAddress.UpdateContactMediumAddressResponseDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/api/contactmediumaddresses")
@RequiredArgsConstructor
public class ContactMediumAddressesController {
    private final ContactMediumAddressService contactMediumAddressService;

    @GetMapping
    public List<ListContactMediumAddressResponseDto> getAll(){
        return contactMediumAddressService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetByIdContactMediumAddressResponseDto> getById(@PathVariable Long id){
        GetByIdContactMediumAddressResponseDto contactMediumAddressResponseDto = contactMediumAddressService.getById(id);

        if (contactMediumAddressResponseDto != null) {
            return ResponseEntity.ok(contactMediumAddressResponseDto);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping
    public ResponseEntity<CreateContactMediumAddressResponseDto> add(@RequestBody @Valid CreateContactMediumAddressRequestDto contactMediumAddress){
        CreateContactMediumAddressResponseDto _contactMediumAddress = contactMediumAddressService.add(contactMediumAddress);

        if (_contactMediumAddress != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(_contactMediumAddress);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        GetByIdContactMediumAddressResponseDto country = contactMediumAddressService.getById(id);

        if (country != null) {
            contactMediumAddressService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PutMapping
    public ResponseEntity<UpdateContactMediumAddressResponseDto> update(@RequestBody @Valid UpdateContactMediumAddressRequestDto contactMediumAddress){
        GetByIdContactMediumAddressResponseDto contactMediumAddressDto = contactMediumAddressService.getById(contactMediumAddress.getId());

        if (contactMediumAddressDto != null) {
            UpdateContactMediumAddressResponseDto contactMediumAddressResponseDto = contactMediumAddressService.update(contactMediumAddress);
            return ResponseEntity.ok(contactMediumAddressResponseDto);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
