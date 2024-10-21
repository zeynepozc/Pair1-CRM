package com.etiya.customerservice.controller;

import com.etiya.customerservice.service.abstracts.ContactMediumService;
import com.etiya.customerservice.service.dto.request.contactMedium.CreateContactMediumRequestDto;
import com.etiya.customerservice.service.dto.request.contactMedium.UpdateContactMediumRequestDto;
import com.etiya.customerservice.service.dto.response.contactMedium.CreateContactMediumResponseDto;
import com.etiya.customerservice.service.dto.response.contactMedium.GetByIdContactMediumResponseDto;
import com.etiya.customerservice.service.dto.response.contactMedium.ListContactMediumResponseDto;
import com.etiya.customerservice.service.dto.response.contactMedium.UpdateContactMediumResponseDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/api/contactmediums")
@RequiredArgsConstructor
public class ContactMediumsController {
    private final ContactMediumService contactMediumService;

    @GetMapping
    public List<ListContactMediumResponseDto> getAll(){
        return contactMediumService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetByIdContactMediumResponseDto> getById(@PathVariable Long id){
        GetByIdContactMediumResponseDto contactMediumResponseDto = contactMediumService.getById(id);

        if (contactMediumResponseDto != null) {
            return ResponseEntity.ok(contactMediumResponseDto);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping
    public ResponseEntity<CreateContactMediumResponseDto> add(@RequestBody @Valid CreateContactMediumRequestDto contactMedium){
        CreateContactMediumResponseDto _contactMedium = contactMediumService.add(contactMedium);

        if (_contactMedium != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(_contactMedium);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        GetByIdContactMediumResponseDto country = contactMediumService.getById(id);

        if (country != null) {
            contactMediumService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PutMapping
    public ResponseEntity<UpdateContactMediumResponseDto> update(@RequestBody @Valid UpdateContactMediumRequestDto contactMedium){
        GetByIdContactMediumResponseDto contactMediumDto = contactMediumService.getById(contactMedium.getId());

        if (contactMediumDto != null) {
            UpdateContactMediumResponseDto contactMediumResponseDto = contactMediumService.update(contactMedium);
            return ResponseEntity.ok(contactMediumResponseDto);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
