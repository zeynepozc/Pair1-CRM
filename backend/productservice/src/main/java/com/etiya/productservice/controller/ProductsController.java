package com.etiya.productservice.controller;

import com.etiya.productservice.service.dto.request.product.CreateProductRequestDto;
import com.etiya.productservice.service.dto.request.product.UpdateProductRequestDto;
import com.etiya.productservice.service.dto.responses.product.CreateProductResponseDto;
import com.etiya.productservice.service.dto.responses.product.GetByIdProductResponseDto;
import com.etiya.productservice.service.dto.responses.product.ListProductResponseDto;
import com.etiya.productservice.service.abstracts.ProductService;
import com.etiya.productservice.service.dto.responses.product.UpdateProductResponseDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductsController {
  private final ProductService productService;

  @GetMapping
  public List<ListProductResponseDto> getAll(){
    return productService.getAll();
  }

  @GetMapping("/{id}")
  public ResponseEntity<GetByIdProductResponseDto> getById(@PathVariable Long id){
    GetByIdProductResponseDto productResponseDto = productService.getById(id);

    if (productResponseDto != null) {
      return ResponseEntity.ok(productResponseDto);
    } else {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
  }

  @PostMapping
  public ResponseEntity<CreateProductResponseDto> add(@RequestBody @Valid CreateProductRequestDto product){
    CreateProductResponseDto _product = productService.add(product);

    if (_product != null) {
      return ResponseEntity.status(HttpStatus.CREATED).body(_product);
    } else {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable Long id){
    GetByIdProductResponseDto country = productService.getById(id);

    if (country != null) {
      productService.delete(id);
      return new ResponseEntity<>(HttpStatus.OK);
    } else {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
  }

  @PutMapping
  public ResponseEntity<UpdateProductResponseDto> getById(@RequestBody @Valid UpdateProductRequestDto product){
    GetByIdProductResponseDto productDto = productService.getById(product.getId());

    if (productDto != null) {
      UpdateProductResponseDto productResponseDto = productService.update(product);
      return ResponseEntity.ok(productResponseDto);
    } else {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
  }
}
