package com.etiya.productservice.service.abstracts;


import com.etiya.productservice.service.dto.request.product.CreateProductRequestDto;
import com.etiya.productservice.service.dto.request.product.UpdateProductRequestDto;
import com.etiya.productservice.service.dto.responses.product.CreateProductResponseDto;
import com.etiya.productservice.service.dto.responses.product.GetByIdProductResponseDto;
import com.etiya.productservice.service.dto.responses.product.ListProductResponseDto;
import com.etiya.productservice.service.dto.responses.product.UpdateProductResponseDto;

import java.util.List;

public interface ProductService {
    List<ListProductResponseDto> getAll();
    GetByIdProductResponseDto getById(Long id);
    CreateProductResponseDto add(CreateProductRequestDto dto);
    UpdateProductResponseDto update(UpdateProductRequestDto dto);
    void delete(Long id);
}
