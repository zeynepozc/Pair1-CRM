package com.etiya.customerservice.controller;

import com.etiya.customerservice.service.abstracts.CustomerAccountService;
import com.etiya.customerservice.service.dto.request.customerAccount.CreateCustomerAccountRequestDto;
import com.etiya.customerservice.service.dto.request.customerAccount.UpdateCustomerAccountRequestDto;
import com.etiya.customerservice.service.dto.response.customerAccount.*;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/api/customeraccounts")
@RequiredArgsConstructor
public class CustomerAccountsController {
    private final CustomerAccountService customerAccountService;

    @GetMapping
    public List<ListCustomerAccountResponseDto> getAll(){
        return customerAccountService.getAll();
    }

    @GetMapping("/customer/{id}")
    public ResponseEntity<List<ListCustomerAccountWithProductsResponseDto>> getByCustomerId(@PathVariable Long id){
        List<ListCustomerAccountWithProductsResponseDto> customerAccountResponseListDto = customerAccountService.getAllByCustomerId(id);
        return ResponseEntity.ok(customerAccountResponseListDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetByIdCustomerAccountResponseDto> getById(@PathVariable Long id){
        GetByIdCustomerAccountResponseDto customerAccountResponseDto = customerAccountService.getById(id);

        if (customerAccountResponseDto != null) {
            return ResponseEntity.ok(customerAccountResponseDto);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping
    public ResponseEntity<CreateCustomerAccountResponseDto> add(@RequestBody @Valid CreateCustomerAccountRequestDto customerAccount){
        CreateCustomerAccountResponseDto _customerAccount = customerAccountService.addCustomerAccountAndBillingAccount(customerAccount);

        if (_customerAccount != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(_customerAccount);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        GetByIdCustomerAccountResponseDto customerAccount = customerAccountService.getById(id);

        if (customerAccount != null) {
            customerAccountService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PutMapping
    public ResponseEntity<UpdateCustomerAccountResponseDto> update(@RequestBody @Valid UpdateCustomerAccountRequestDto customerAccount){
        GetByIdCustomerAccountResponseDto customerAccountDto = customerAccountService.getById(customerAccount.getId());

        if (customerAccountDto != null) {
            UpdateCustomerAccountResponseDto customerAccountResponseDto = customerAccountService.update(customerAccount);
            return ResponseEntity.ok(customerAccountResponseDto);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
