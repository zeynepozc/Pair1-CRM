package com.etiya.productservice.mapper;

import com.etiya.productservice.entity.ProductSpecification;
import com.etiya.productservice.service.dto.request.productSpecification.CreateProductSpecificationRequestDto;
import com.etiya.productservice.service.dto.request.productSpecification.UpdateProductSpecificationRequestDto;
import com.etiya.productservice.service.dto.responses.productSpecification.CreateProductSpecificationResponseDto;
import com.etiya.productservice.service.dto.responses.productSpecification.GetByIdProductSpecificationResponseDto;
import com.etiya.productservice.service.dto.responses.productSpecification.ListProductSpecificationResponseDto;
import com.etiya.productservice.service.dto.responses.productSpecification.UpdateProductSpecificationResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public abstract class ProductSpecificationMapper {
    @Mapping(source="productId", target = "product.id")
    @Mapping(source="attributeValueId", target = "attributeValue.id")
    public abstract ProductSpecification productSpecificationFromCreateProductSpecificationRequestDto(CreateProductSpecificationRequestDto createProductSpecificationRequestDto);
    @Mapping(source = "product.id",target="productId")
    @Mapping(source = "attributeValue.id",target="attributeValueId")
    public abstract CreateProductSpecificationResponseDto createProductSpecificationResponseDtoFromProductSpecification(ProductSpecification productSpecification);
    @Mapping(source="productId", target = "product.id")
    @Mapping(source="attributeValueId", target = "attributeValue.id")
    public abstract ProductSpecification productSpecificationFromUpdateProductSpecificationRequestDto(UpdateProductSpecificationRequestDto updateProductSpecificationRequestDto);
    @Mapping(source = "product.id",target="productId")
    @Mapping(source = "attributeValue.id",target="attributeValueId")
    public abstract UpdateProductSpecificationResponseDto updateProductSpecificationResponseDtoFromProductSpecification(ProductSpecification productSpecification);
    @Mapping(source = "product.id",target="productId")
    @Mapping(source = "attributeValue.id",target="attributeValueId")
    public abstract List<ListProductSpecificationResponseDto> productSpecificationList(List<ProductSpecification> productSpecificationList);
    @Mapping(source = "product.id",target="productId")
    @Mapping(source = "attributeValue.id",target="attributeValueId")
    public abstract ListProductSpecificationResponseDto productSpecificationList(ProductSpecification productSpecification);
    @Mapping(source = "product.id",target="productId")
    @Mapping(source = "attributeValue.id",target="attributeValueId")
    public abstract GetByIdProductSpecificationResponseDto getByIdProductSpecificationResponseDtoFromProductSpecification(ProductSpecification productSpecification);
}
