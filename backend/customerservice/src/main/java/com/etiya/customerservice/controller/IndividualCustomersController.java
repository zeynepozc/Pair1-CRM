package com.etiya.customerservice.controller;

import com.etiya.customerservice.service.abstracts.IndividualCustomerService;
import com.etiya.customerservice.service.dto.request.individualCustomer.CreateIndividualCustomerRequestDto;
import com.etiya.customerservice.service.dto.request.individualCustomer.UpdateIndividualCustomerRequestDto;
import com.etiya.customerservice.service.dto.response.individualCustomer.CreateIndividualCustomerResponseDto;
import com.etiya.customerservice.service.dto.response.individualCustomer.GetByIdIndividualCustomerResponseDto;
import com.etiya.customerservice.service.dto.response.individualCustomer.ListIndividualCustomerResponseDto;
import com.etiya.customerservice.service.dto.response.individualCustomer.UpdateIndividualCustomerResponseDto;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/api/individualcustomers")
@RequiredArgsConstructor
public class IndividualCustomersController {
  private final IndividualCustomerService individualCustomerService;

  @GetMapping
  public List<ListIndividualCustomerResponseDto> getAll(){
    return individualCustomerService.getAll();
  }

  @GetMapping("/{id}")
  public ResponseEntity<GetByIdIndividualCustomerResponseDto> getById(@PathVariable Long id){
    GetByIdIndividualCustomerResponseDto individualCustomerResponseDto = individualCustomerService.getById(id);

    if (individualCustomerResponseDto != null) {
      return ResponseEntity.ok(individualCustomerResponseDto);
    } else {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
  }

  @PostMapping
  public ResponseEntity<CreateIndividualCustomerResponseDto> add(@RequestBody @Valid CreateIndividualCustomerRequestDto individualCustomer){
    CreateIndividualCustomerResponseDto _individualCustomer = individualCustomerService.add(individualCustomer);

    if (_individualCustomer != null) {
      return ResponseEntity.status(HttpStatus.CREATED).body(_individualCustomer);
    } else {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable Long id){
    GetByIdIndividualCustomerResponseDto country = individualCustomerService.getById(id);

    if (country != null) {
      individualCustomerService.delete(id);
      return new ResponseEntity<>(HttpStatus.OK);
    } else {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
  }

  @PutMapping
  public ResponseEntity<UpdateIndividualCustomerResponseDto> update(@RequestBody @Valid UpdateIndividualCustomerRequestDto individualCustomer){
    GetByIdIndividualCustomerResponseDto individualCustomerDto = individualCustomerService.getById(individualCustomer.getId());

    if (individualCustomerDto != null) {
      UpdateIndividualCustomerResponseDto individualCustomerResponseDto = individualCustomerService.update(individualCustomer);
      return ResponseEntity.ok(individualCustomerResponseDto);
    } else {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
  }
}
