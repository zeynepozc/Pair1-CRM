package com.etiya.productservice.controller;

import com.etiya.productservice.service.abstracts.ProductImageService;
import com.etiya.productservice.service.dto.request.productImage.CreateProductImageRequestDto;
import com.etiya.productservice.service.dto.request.productImage.UpdateProductImageRequestDto;
import com.etiya.productservice.service.dto.responses.productImage.CreateProductImageResponseDto;
import com.etiya.productservice.service.dto.responses.productImage.GetByIdProductImageResponseDto;
import com.etiya.productservice.service.dto.responses.productImage.ListProductImageResponseDto;
import com.etiya.productservice.service.dto.responses.productImage.UpdateProductImageResponseDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/api/productImages")
@RequiredArgsConstructor
public class ProductImagesController {
    private final ProductImageService productImageService;
    @GetMapping
    public List<ListProductImageResponseDto> getAll(){
        return productImageService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetByIdProductImageResponseDto> getById(@PathVariable Long id){
        GetByIdProductImageResponseDto productImage = productImageService.getById(id);

        if (productImage != null) {
            return ResponseEntity.ok(productImage);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
    @PostMapping
    public ResponseEntity<CreateProductImageResponseDto> add(@RequestBody @Valid CreateProductImageRequestDto createProductImageRequestDto){
        CreateProductImageResponseDto createProductImageResponseDto = productImageService.add(createProductImageRequestDto);

        if (createProductImageResponseDto != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(createProductImageResponseDto);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        GetByIdProductImageResponseDto productImage = productImageService.getById(id);

        if (productImage != null) {
            productImageService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<UpdateProductImageResponseDto> update(@PathVariable Long id, @RequestBody @Valid UpdateProductImageRequestDto updateProductImageRequestDto){
        UpdateProductImageResponseDto productImage = productImageService.update(id, updateProductImageRequestDto);

        if (productImage != null) {
            return ResponseEntity.ok(productImage);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
