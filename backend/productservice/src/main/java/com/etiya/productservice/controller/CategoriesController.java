package com.etiya.productservice.controller;

import com.etiya.productservice.service.abstracts.CategoryService;
import com.etiya.productservice.service.dto.request.category.CreateCategoryRequestDto;
import com.etiya.productservice.service.dto.request.category.UpdateCategoryRequestDto;
import com.etiya.productservice.service.dto.responses.category.GetByIdCategoryResponseDto;
import com.etiya.productservice.service.dto.responses.category.ListCategoryResponseDto;
import com.etiya.productservice.service.dto.responses.category.UpdateCategoryResponseDto;
import com.etiya.productservice.service.dto.responses.category.CreateCategoryResponseDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/categories")
@RequiredArgsConstructor
public class CategoriesController {
    private final CategoryService categoryService;

    @GetMapping
    public List<ListCategoryResponseDto> getAll(){
        return categoryService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetByIdCategoryResponseDto> getById(@PathVariable Long id){
        GetByIdCategoryResponseDto categoryResponseDto = categoryService.getById(id);

        if (categoryResponseDto != null) {
            return ResponseEntity.ok(categoryResponseDto);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping
    public ResponseEntity<CreateCategoryResponseDto> add(@RequestBody @Valid CreateCategoryRequestDto category){
        CreateCategoryResponseDto _category = categoryService.add(category);

        if (_category != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(_category);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        GetByIdCategoryResponseDto country = categoryService.getById(id);

        if (country != null) {
            categoryService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PutMapping
    public ResponseEntity<UpdateCategoryResponseDto> update(@RequestBody @Valid UpdateCategoryRequestDto category){
        GetByIdCategoryResponseDto categoryDto = categoryService.getById(category.getId());

        if (categoryDto != null) {
            UpdateCategoryResponseDto categoryResponseDto = categoryService.update(category);
            return ResponseEntity.ok(categoryResponseDto);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
