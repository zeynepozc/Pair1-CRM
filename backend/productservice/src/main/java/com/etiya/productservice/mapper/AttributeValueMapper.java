package com.etiya.productservice.mapper;

import com.etiya.productservice.service.dto.request.attributeValue.CreateAttributeValueRequestDto;
import com.etiya.productservice.service.dto.request.attributeValue.UpdateAttributeValueRequestDto;
import com.etiya.productservice.service.dto.responses.attributeValue.CreateAttributeValueResponseDto;
import com.etiya.productservice.service.dto.responses.attributeValue.GetByIdAttributeValueResponseDto;
import com.etiya.productservice.service.dto.responses.attributeValue.ListAttributeValueResponseDto;
import com.etiya.productservice.service.dto.responses.attributeValue.UpdateAttributeValueResponseDto;
import com.etiya.productservice.entity.AttributeValue;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public abstract class AttributeValueMapper {
    @Mapping(source="attributeId", target = "productAttribute.id")
    public abstract AttributeValue attributeValueFromCreateAttributeValueRequestDto(CreateAttributeValueRequestDto createAttributeValueRequestDto);
    @Mapping(source = "productAttribute.id", target="attributeId")
    public abstract CreateAttributeValueResponseDto createAttributeValueResponseDtoFromAttributeValue(AttributeValue attributeValue);
    @Mapping(source="attributeId", target = "productAttribute.id")
    public abstract AttributeValue attributeValueFromUpdateAttributeValueRequestDto(UpdateAttributeValueRequestDto updateAttributeValueRequestDto);
    @Mapping(source = "productAttribute.id", target="attributeId")
    public abstract UpdateAttributeValueResponseDto updateAttributeValueResponseDtoFromAttributeValue(AttributeValue attributeValue);
    @Mapping(source = "productAttribute.id", target="attributeId")
    public abstract List<ListAttributeValueResponseDto> attributeValueList(List<AttributeValue> attributeValueList);
    @Mapping(source = "productAttribute.id", target="attributeId")
    public abstract ListAttributeValueResponseDto attributeValueList(AttributeValue attributeValue);
    @Mapping(source = "productAttribute.id", target="attributeId")
    public abstract GetByIdAttributeValueResponseDto getByIdAttributeValueResponseDtoFromAttributeValue(AttributeValue attributeValue);
}
