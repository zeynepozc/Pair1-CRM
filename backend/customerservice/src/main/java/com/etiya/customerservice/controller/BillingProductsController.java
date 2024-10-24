package com.etiya.customerservice.controller;

import com.etiya.customerservice.service.abstracts.BillingProductService;
import com.etiya.customerservice.service.dto.request.billingProduct.CreateBillingProductRequestDto;
import com.etiya.customerservice.service.dto.response.billingProduct.CreateBillingProductResponseDto;
import com.etiya.customerservice.service.dto.response.billingProduct.GetByIdBillingProductResponseDto;
import com.etiya.customerservice.service.dto.response.billingProduct.ListBillingProductResponseDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/api/billingproducts")
@RequiredArgsConstructor
public class
BillingProductsController {
    private final BillingProductService billingProductService;

    @GetMapping
    public List<ListBillingProductResponseDto> getAll(){
        return billingProductService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetByIdBillingProductResponseDto> getById(@PathVariable Long id){
        GetByIdBillingProductResponseDto billingProductResponseDto = billingProductService.getById(id);

        if (billingProductResponseDto != null) {
            return ResponseEntity.ok(billingProductResponseDto);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping
    public ResponseEntity<CreateBillingProductResponseDto> add(@RequestBody @Valid CreateBillingProductRequestDto billingProduct){
        CreateBillingProductResponseDto _billingProduct = billingProductService.add(billingProduct);

        if (_billingProduct != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(_billingProduct);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        GetByIdBillingProductResponseDto billingProduct = billingProductService.getById(id);

        if (billingProduct != null) {
            billingProductService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
