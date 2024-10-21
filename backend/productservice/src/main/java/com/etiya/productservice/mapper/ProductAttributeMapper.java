package com.etiya.productservice.mapper;

import com.etiya.productservice.service.dto.request.productAttribute.CreateProductAttributeRequestDto;
import com.etiya.productservice.service.dto.request.productAttribute.UpdateProductAttributeRequestDto;
import com.etiya.productservice.service.dto.responses.productAttribute.CreateProductAttributeResponseDto;
import com.etiya.productservice.service.dto.responses.productAttribute.GetByIdProductAttributeResponseDto;
import com.etiya.productservice.service.dto.responses.productAttribute.ListProductAttributeResponseDto;
import com.etiya.productservice.service.dto.responses.productAttribute.UpdateProductAttributeResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import com.etiya.productservice.entity.ProductAttribute;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public abstract class ProductAttributeMapper {
    public abstract  ProductAttribute productAttributeFromCreateProductAttributeRequestDto(CreateProductAttributeRequestDto createProductAttributeRequestDto);
    public abstract CreateProductAttributeResponseDto createProductAttributeResponseDtoFromProductAttribute(ProductAttribute productAttribute);
    public abstract ProductAttribute productAttributeFromUpdateProductAttributeRequestDto(UpdateProductAttributeRequestDto updateProductAttributeRequestDto);
    public abstract UpdateProductAttributeResponseDto updateProductAttributeResponseDtoFromProductAttribute(ProductAttribute productAttribute);
    public abstract List<ListProductAttributeResponseDto> productAttributeList(List<ProductAttribute> productAttributeList);
    public abstract GetByIdProductAttributeResponseDto getByIdProductAttributeResponseDtoFromProductAttribute(ProductAttribute productAttribute);
}
