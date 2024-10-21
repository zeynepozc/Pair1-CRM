package com.etiya.customerservice.controller;

import com.etiya.customerservice.service.abstracts.BillingAccountService;
import com.etiya.customerservice.service.dto.request.billingAccount.CreateBillingAccountRequestDto;
import com.etiya.customerservice.service.dto.request.billingAccount.UpdateBillingAccountRequestDto;
import com.etiya.customerservice.service.dto.response.billingAccount.CreateBillingAccountResponseDto;
import com.etiya.customerservice.service.dto.response.billingAccount.GetByIdBillingAccountResponseDto;
import com.etiya.customerservice.service.dto.response.billingAccount.ListBillingAccountResponseDto;
import com.etiya.customerservice.service.dto.response.billingAccount.UpdateBillingAccountResponseDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/api/billingaccounts")
@RequiredArgsConstructor
public class BillingAccountsController {
    private final BillingAccountService billingAccountService;

    @GetMapping
    public List<ListBillingAccountResponseDto> getAll(){
        return billingAccountService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetByIdBillingAccountResponseDto> getById(@PathVariable Long id){
        GetByIdBillingAccountResponseDto billingAccountResponseDto = billingAccountService.getById(id);

        if (billingAccountResponseDto != null) {
            return ResponseEntity.ok(billingAccountResponseDto);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping
    public ResponseEntity<CreateBillingAccountResponseDto> add(@RequestBody @Valid CreateBillingAccountRequestDto billingAccount){
        CreateBillingAccountResponseDto _billingAccount = billingAccountService.add(billingAccount);

        if (_billingAccount != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(_billingAccount);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        GetByIdBillingAccountResponseDto billingAccount = billingAccountService.getById(id);

        if (billingAccount != null) {
            billingAccountService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PutMapping
    public ResponseEntity<UpdateBillingAccountResponseDto> update(@RequestBody @Valid UpdateBillingAccountRequestDto billingAccount){
        GetByIdBillingAccountResponseDto billingAccountDto = billingAccountService.getById(billingAccount.getId());

        if (billingAccountDto != null) {
            UpdateBillingAccountResponseDto billingAccountResponseDto = billingAccountService.update(billingAccount);
            return ResponseEntity.ok(billingAccountResponseDto);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}