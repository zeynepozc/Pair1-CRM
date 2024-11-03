package com.etiya.customerservice.controller;

import com.etiya.customerservice.service.abstracts.IndividualCustomerService;
import com.etiya.customerservice.service.dto.request.individualCustomer.CreateIndividualCustomerRequestDto;
import com.etiya.customerservice.service.dto.request.individualCustomer.IsCustomerExistsWithNatIDRequestDto;
import com.etiya.customerservice.service.dto.request.individualCustomer.SearchIndividualCustomerRequestDto;
import com.etiya.customerservice.service.dto.request.individualCustomer.UpdateIndividualCustomerRequestDto;
import com.etiya.customerservice.service.dto.response.individualCustomer.*;

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

  @PostMapping("/search")
  public ResponseEntity<List<SearchIndividualCustomerResponseDto>> searchByFilters(@RequestBody SearchIndividualCustomerRequestDto individualCustomerRequestDto){
    List<SearchIndividualCustomerResponseDto> customerResponseDtoList = individualCustomerService.searchByFilters(individualCustomerRequestDto);

    return ResponseEntity.status(HttpStatus.OK).body(customerResponseDtoList);
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
    GetByIdIndividualCustomerResponseDto customer = individualCustomerService.getById(id);

    if (customer != null) {
      individualCustomerService.delete(id);
      return new ResponseEntity<>(HttpStatus.OK);
    } else {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
  }

  @PutMapping
  public ResponseEntity<UpdateIndividualCustomerResponseDto> update(@RequestBody UpdateIndividualCustomerRequestDto individualCustomer){
    GetByIdIndividualCustomerResponseDto individualCustomerDto = individualCustomerService.getById(individualCustomer.getId());

    if (individualCustomerDto != null) {
      UpdateIndividualCustomerResponseDto individualCustomerResponseDto = individualCustomerService.update(individualCustomer);
      return ResponseEntity.ok(individualCustomerResponseDto);
    } else {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
  }

  @PostMapping("/isCustomerExistsWithNatID")
  public ResponseEntity<IsCustomerExistsWithNatIDResponseDto> isCustomerExistsWithNatID(@RequestBody IsCustomerExistsWithNatIDRequestDto dto){
    IsCustomerExistsWithNatIDResponseDto isCustomerExist = individualCustomerService.isCustomerExistsWithNatID(dto);

    if (isCustomerExist != null) {
      return ResponseEntity.status(HttpStatus.OK).body(isCustomerExist);
    } else {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
  }


}
