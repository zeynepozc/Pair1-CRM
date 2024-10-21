package com.etiya.productservice.service.concrete;

import com.etiya.productservice.entity.AttributeValue;
import com.etiya.productservice.mapper.AttributeValueMapper;
import com.etiya.productservice.repository.AttributeValueRepository;
import com.etiya.productservice.service.abstracts.AttributeValueService;
import com.etiya.productservice.service.dto.request.attributeValue.CreateAttributeValueRequestDto;
import com.etiya.productservice.service.dto.request.attributeValue.UpdateAttributeValueRequestDto;
import com.etiya.productservice.service.dto.responses.attributeValue.CreateAttributeValueResponseDto;
import com.etiya.productservice.service.dto.responses.attributeValue.GetByIdAttributeValueResponseDto;
import com.etiya.productservice.service.dto.responses.attributeValue.ListAttributeValueResponseDto;
import com.etiya.productservice.service.dto.responses.attributeValue.UpdateAttributeValueResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class AttributeValueServiceImpl implements AttributeValueService {
    private final AttributeValueRepository attributeValueRepository;
    private final AttributeValueMapper attributeValueMapper;
    @Override
    public List<ListAttributeValueResponseDto> getAll() {
        List<AttributeValue> attributeValues = attributeValueRepository.findAll();
        return attributeValueMapper.attributeValueList(attributeValues);
    }

    @Override
    public GetByIdAttributeValueResponseDto getById(Long id) {
        AttributeValue attributeValue = attributeValueRepository.findById(id).orElseThrow();
        return attributeValueMapper.getByIdAttributeValueResponseDtoFromAttributeValue(attributeValue);
    }

    @Override
    public CreateAttributeValueResponseDto add(CreateAttributeValueRequestDto createAttributeValueRequestDto) {
        AttributeValue attributeValue = attributeValueMapper.attributeValueFromCreateAttributeValueRequestDto(createAttributeValueRequestDto);
        attributeValue.setActive(true);
        AttributeValue addedAttributeValue = attributeValueRepository.save(attributeValue);
        return attributeValueMapper.createAttributeValueResponseDtoFromAttributeValue(addedAttributeValue);
    }

    @Override
    public void delete(Long id) {
        attributeValueRepository.deleteById(id);
    }

    @Override
    public UpdateAttributeValueResponseDto update(Long id, UpdateAttributeValueRequestDto updateAttributeValueRequestDto) {
        AttributeValue attributeValue = attributeValueMapper.attributeValueFromUpdateAttributeValueRequestDto(updateAttributeValueRequestDto);
        attributeValue.setId(id);
        AttributeValue updatedAttributeValue = attributeValueRepository.save(attributeValue);
        return attributeValueMapper.updateAttributeValueResponseDtoFromAttributeValue(updatedAttributeValue);
    }
}
