package com.etiya.productservice.service.abstracts;

import com.etiya.productservice.service.dto.request.productSpecification.CreateProductSpecificationRequestDto;
import com.etiya.productservice.service.dto.request.productSpecification.UpdateProductSpecificationRequestDto;
import com.etiya.productservice.service.dto.responses.productSpecification.CreateProductSpecificationResponseDto;
import com.etiya.productservice.service.dto.responses.productSpecification.GetByIdProductSpecificationResponseDto;
import com.etiya.productservice.service.dto.responses.productSpecification.ListProductSpecificationResponseDto;
import com.etiya.productservice.service.dto.responses.productSpecification.UpdateProductSpecificationResponseDto;

import java.util.List;

public interface ProductSpecificationService {
    List<ListProductSpecificationResponseDto> getAll();
    GetByIdProductSpecificationResponseDto getById(Long id);
    CreateProductSpecificationResponseDto add(CreateProductSpecificationRequestDto createProductSpecificationRequestDto);
    void delete(Long id);
    UpdateProductSpecificationResponseDto update(Long id, UpdateProductSpecificationRequestDto updateProductSpecificationRequestDto);
}
