package com.etiya.productservice.service.abstracts;

import com.etiya.productservice.service.dto.request.productImage.CreateProductImageRequestDto;
import com.etiya.productservice.service.dto.request.productImage.UpdateProductImageRequestDto;
import com.etiya.productservice.service.dto.responses.productImage.CreateProductImageResponseDto;
import com.etiya.productservice.service.dto.responses.productImage.GetByIdProductImageResponseDto;
import com.etiya.productservice.service.dto.responses.productImage.ListProductImageResponseDto;
import com.etiya.productservice.service.dto.responses.productImage.UpdateProductImageResponseDto;

import java.util.List;

public interface ProductImageService {
    List<ListProductImageResponseDto> getAll();
    GetByIdProductImageResponseDto getById(Long id);
    CreateProductImageResponseDto add(CreateProductImageRequestDto createProductImageRequestDto);
    void delete(Long id);
    UpdateProductImageResponseDto update(Long id, UpdateProductImageRequestDto updateProductImageRequestDto);
}
