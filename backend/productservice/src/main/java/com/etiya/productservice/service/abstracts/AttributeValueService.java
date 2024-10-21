package com.etiya.productservice.service.abstracts;

import com.etiya.productservice.service.dto.request.attributeValue.CreateAttributeValueRequestDto;
import com.etiya.productservice.service.dto.request.attributeValue.UpdateAttributeValueRequestDto;
import com.etiya.productservice.service.dto.responses.attributeValue.CreateAttributeValueResponseDto;
import com.etiya.productservice.service.dto.responses.attributeValue.GetByIdAttributeValueResponseDto;
import com.etiya.productservice.service.dto.responses.attributeValue.ListAttributeValueResponseDto;
import com.etiya.productservice.service.dto.responses.attributeValue.UpdateAttributeValueResponseDto;

import java.util.List;

public interface AttributeValueService {
    List<ListAttributeValueResponseDto> getAll();
    GetByIdAttributeValueResponseDto getById(Long id);
    CreateAttributeValueResponseDto add(CreateAttributeValueRequestDto createAttributeValueRequestDto);
    void delete(Long id);
    UpdateAttributeValueResponseDto update(Long id, UpdateAttributeValueRequestDto updateAttributeValueRequestDto);
}
