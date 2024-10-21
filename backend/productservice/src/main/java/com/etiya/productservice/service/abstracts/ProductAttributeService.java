package com.etiya.productservice.service.abstracts;

import com.etiya.productservice.service.dto.request.productAttribute.CreateProductAttributeRequestDto;
import com.etiya.productservice.service.dto.request.productAttribute.UpdateProductAttributeRequestDto;
import com.etiya.productservice.service.dto.responses.productAttribute.CreateProductAttributeResponseDto;
import com.etiya.productservice.service.dto.responses.productAttribute.GetByIdProductAttributeResponseDto;
import com.etiya.productservice.service.dto.responses.productAttribute.ListProductAttributeResponseDto;
import com.etiya.productservice.service.dto.responses.productAttribute.UpdateProductAttributeResponseDto;

import java.util.List;

public interface ProductAttributeService {
    List<ListProductAttributeResponseDto> getAll();
    GetByIdProductAttributeResponseDto getById(Long id);
    CreateProductAttributeResponseDto add(CreateProductAttributeRequestDto createProductAttributeRequestDto);
    void delete(Long id);
    UpdateProductAttributeResponseDto update(Long id, UpdateProductAttributeRequestDto updateProductAttributeRequestDto);
}
