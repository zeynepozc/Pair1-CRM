package com.etiya.productservice.controller;

import com.etiya.productservice.service.dto.request.productAttribute.CreateProductAttributeRequestDto;
import com.etiya.productservice.service.dto.request.productAttribute.UpdateProductAttributeRequestDto;
import com.etiya.productservice.service.dto.responses.productAttribute.CreateProductAttributeResponseDto;
import com.etiya.productservice.service.dto.responses.productAttribute.GetByIdProductAttributeResponseDto;
import com.etiya.productservice.service.dto.responses.productAttribute.UpdateProductAttributeResponseDto;
import com.etiya.productservice.service.abstracts.ProductAttributeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.etiya.productservice.service.dto.responses.productAttribute.ListProductAttributeResponseDto;

import java.util.List;

@RestController()
@RequestMapping("/api/productAttributes")
@RequiredArgsConstructor
public class ProductAttributesController {
    private final ProductAttributeService productAttributeService;
    @GetMapping
    public List<ListProductAttributeResponseDto> getAll(){
        return productAttributeService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetByIdProductAttributeResponseDto> getById(@PathVariable Long id){
        GetByIdProductAttributeResponseDto productAttribute = productAttributeService.getById(id);

        if (productAttribute != null) {
            return ResponseEntity.ok(productAttribute);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
    @PostMapping
    public ResponseEntity<CreateProductAttributeResponseDto> add(@RequestBody @Valid CreateProductAttributeRequestDto createProductAttributeRequestDto){
        CreateProductAttributeResponseDto createProductAttributeResponseDto = productAttributeService.add(createProductAttributeRequestDto);

        if (createProductAttributeResponseDto != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(createProductAttributeResponseDto);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        GetByIdProductAttributeResponseDto productAttribute = productAttributeService.getById(id);

        if (productAttribute != null) {
            productAttributeService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<UpdateProductAttributeResponseDto> update(@PathVariable Long id, @RequestBody @Valid UpdateProductAttributeRequestDto updateProductAttributeRequestDto){
        UpdateProductAttributeResponseDto productAttribute = productAttributeService.update(id, updateProductAttributeRequestDto);

        if (productAttribute != null) {
            return ResponseEntity.ok(productAttribute);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

}
