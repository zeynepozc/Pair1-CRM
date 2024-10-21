package com.etiya.customerservice.controller;

import com.etiya.customerservice.service.abstracts.ContactAddressService;
import com.etiya.customerservice.service.dto.request.contactAddress.CreateContactAddressRequestDto;
import com.etiya.customerservice.service.dto.request.contactAddress.UpdateContactAddressRequestDto;
import com.etiya.customerservice.service.dto.response.contactAddress.CreateContactAddressResponseDto;
import com.etiya.customerservice.service.dto.response.contactAddress.GetByIdContactAddressResponseDto;
import com.etiya.customerservice.service.dto.response.contactAddress.ListContactAddressResponseDto;
import com.etiya.customerservice.service.dto.response.contactAddress.UpdateContactAddressResponseDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/api/contactaddresses")
@RequiredArgsConstructor
public class ContactAddressesController {
    private final ContactAddressService contactAddressService;

    @GetMapping
    public List<ListContactAddressResponseDto> getAll(){
        return contactAddressService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetByIdContactAddressResponseDto> getById(@PathVariable Long id){
        GetByIdContactAddressResponseDto contactAddressResponseDto = contactAddressService.getById(id);

        if (contactAddressResponseDto != null) {
            return ResponseEntity.ok(contactAddressResponseDto);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping
    public ResponseEntity<CreateContactAddressResponseDto> add(@RequestBody @Valid CreateContactAddressRequestDto contactAddress){
        CreateContactAddressResponseDto _contactAddress = contactAddressService.add(contactAddress);

        if (_contactAddress != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(_contactAddress);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        GetByIdContactAddressResponseDto country = contactAddressService.getById(id);

        if (country != null) {
            contactAddressService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PutMapping
    public ResponseEntity<UpdateContactAddressResponseDto> update(@RequestBody @Valid UpdateContactAddressRequestDto contactAddress){
        GetByIdContactAddressResponseDto contactAddressDto = contactAddressService.getById(contactAddress.getId());

        if (contactAddressDto != null) {
            UpdateContactAddressResponseDto contactAddressResponseDto = contactAddressService.update(contactAddress);
            return ResponseEntity.ok(contactAddressResponseDto);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
