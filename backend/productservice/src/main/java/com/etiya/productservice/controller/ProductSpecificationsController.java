package com.etiya.productservice.controller;

import com.etiya.productservice.service.abstracts.ProductSpecificationService;
import com.etiya.productservice.service.dto.request.productSpecification.CreateProductSpecificationRequestDto;
import com.etiya.productservice.service.dto.request.productSpecification.UpdateProductSpecificationRequestDto;
import com.etiya.productservice.service.dto.responses.productSpecification.CreateProductSpecificationResponseDto;
import com.etiya.productservice.service.dto.responses.productSpecification.GetByIdProductSpecificationResponseDto;
import com.etiya.productservice.service.dto.responses.productSpecification.ListProductSpecificationResponseDto;
import com.etiya.productservice.service.dto.responses.productSpecification.UpdateProductSpecificationResponseDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/api/productSpecifications")
@RequiredArgsConstructor
public class ProductSpecificationsController {
    private final ProductSpecificationService productSpecificationService;
    @GetMapping
    public List<ListProductSpecificationResponseDto> getAll(){
        return productSpecificationService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetByIdProductSpecificationResponseDto> getById(@PathVariable Long id){
        GetByIdProductSpecificationResponseDto productSpecification = productSpecificationService.getById(id);

        if (productSpecification != null) {
            return ResponseEntity.ok(productSpecification);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
    @PostMapping
    public ResponseEntity<CreateProductSpecificationResponseDto> add(@RequestBody @Valid CreateProductSpecificationRequestDto createProductSpecificationRequestDto){
        CreateProductSpecificationResponseDto createProductSpecificationResponseDto = productSpecificationService.add(createProductSpecificationRequestDto);

        if (createProductSpecificationResponseDto != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(createProductSpecificationResponseDto);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        GetByIdProductSpecificationResponseDto productSpecification = productSpecificationService.getById(id);

        if (productSpecification != null) {
            productSpecificationService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<UpdateProductSpecificationResponseDto> update(@PathVariable Long id, @RequestBody @Valid UpdateProductSpecificationRequestDto updateProductSpecificationRequestDto){
        UpdateProductSpecificationResponseDto productSpecification = productSpecificationService.update(id, updateProductSpecificationRequestDto);

        if (productSpecification != null) {
            return ResponseEntity.ok(productSpecification);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
