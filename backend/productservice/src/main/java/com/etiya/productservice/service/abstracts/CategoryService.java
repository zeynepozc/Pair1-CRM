package com.etiya.productservice.service.abstracts;

import com.etiya.productservice.service.dto.request.category.CreateCategoryRequestDto;
import com.etiya.productservice.service.dto.request.category.UpdateCategoryRequestDto;
import com.etiya.productservice.service.dto.responses.category.CreateCategoryResponseDto;
import com.etiya.productservice.service.dto.responses.category.GetByIdCategoryResponseDto;
import com.etiya.productservice.service.dto.responses.category.ListCategoryResponseDto;
import com.etiya.productservice.service.dto.responses.category.UpdateCategoryResponseDto;

import java.util.List;

public interface CategoryService {
    List<ListCategoryResponseDto> getAll();
    GetByIdCategoryResponseDto getById(Long id);
    CreateCategoryResponseDto add(CreateCategoryRequestDto createCategoryRequestDto);

    UpdateCategoryResponseDto update(UpdateCategoryRequestDto updateCategoryRequestDto);
    void delete(Long id);

}
