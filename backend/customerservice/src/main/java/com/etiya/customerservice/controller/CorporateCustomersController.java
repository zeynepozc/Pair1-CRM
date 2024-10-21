package com.etiya.customerservice.controller;

import com.etiya.customerservice.service.abstracts.CorporateCustomerService;
import com.etiya.customerservice.service.dto.request.corporateCustomer.CreateCorporateCustomerRequestDto;
import com.etiya.customerservice.service.dto.request.corporateCustomer.UpdateCorporateCustomerRequestDto;
import com.etiya.customerservice.service.dto.response.corporateCustomer.CreateCorporateCustomerResponseDto;
import com.etiya.customerservice.service.dto.response.corporateCustomer.GetByIdCorporateCustomerResponseDto;
import com.etiya.customerservice.service.dto.response.corporateCustomer.ListCorporateCustomerResponseDto;
import com.etiya.customerservice.service.dto.response.corporateCustomer.UpdateCorporateCustomerResponseDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController()
@RequestMapping("/api/corporatecustomers")
@RequiredArgsConstructor
public class CorporateCustomersController {
    private final CorporateCustomerService corporateCustomerService;

    @GetMapping
    public List<ListCorporateCustomerResponseDto> getAll(){
        return corporateCustomerService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetByIdCorporateCustomerResponseDto> getById(@PathVariable Long id){
        GetByIdCorporateCustomerResponseDto corporateCustomerResponseDto = corporateCustomerService.getById(id);

        if (corporateCustomerResponseDto != null) {
            return ResponseEntity.ok(corporateCustomerResponseDto);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping
    public ResponseEntity<CreateCorporateCustomerResponseDto> add(@RequestBody @Valid CreateCorporateCustomerRequestDto corporateCustomer){
        CreateCorporateCustomerResponseDto _corporateCustomer = corporateCustomerService.add(corporateCustomer);

        if (_corporateCustomer != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(_corporateCustomer);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        GetByIdCorporateCustomerResponseDto country = corporateCustomerService.getById(id);

        if (country != null) {
            corporateCustomerService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PutMapping
    public ResponseEntity<UpdateCorporateCustomerResponseDto> update(@RequestBody @Valid UpdateCorporateCustomerRequestDto corporateCustomer){
        GetByIdCorporateCustomerResponseDto corporateCustomerDto = corporateCustomerService.getById(corporateCustomer.getId());

        if (corporateCustomerDto != null) {
            UpdateCorporateCustomerResponseDto corporateCustomerResponseDto = corporateCustomerService.update(corporateCustomer);
            return ResponseEntity.ok(corporateCustomerResponseDto);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
