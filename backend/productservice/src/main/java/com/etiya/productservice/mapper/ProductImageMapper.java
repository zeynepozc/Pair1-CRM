package com.etiya.productservice.mapper;

import com.etiya.productservice.entity.ProductImage;
import com.etiya.productservice.service.dto.request.productImage.CreateProductImageRequestDto;
import com.etiya.productservice.service.dto.request.productImage.UpdateProductImageRequestDto;
import com.etiya.productservice.service.dto.responses.productImage.CreateProductImageResponseDto;
import com.etiya.productservice.service.dto.responses.productImage.GetByIdProductImageResponseDto;
import com.etiya.productservice.service.dto.responses.productImage.ListProductImageResponseDto;
import com.etiya.productservice.service.dto.responses.productImage.UpdateProductImageResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public abstract class ProductImageMapper {
    @Mapping(source="productId", target = "product.id")
    public abstract ProductImage productImageFromCreateProductImageRequestDto(CreateProductImageRequestDto createProductImageRequestDto);
    @Mapping(source = "product.id", target="productId")
    public abstract CreateProductImageResponseDto createProductImageResponseDtoFromProductImage(ProductImage productImage);
    @Mapping(source="productId", target = "product.id")
    public abstract ProductImage productImageFromUpdateProductImageRequestDto(UpdateProductImageRequestDto updateProductImageRequestDto);
    @Mapping(source = "product.id", target="productId")
    public abstract UpdateProductImageResponseDto updateProductImageResponseDtoFromProductImage(ProductImage productImage);
    @Mapping(source = "product.id", target="productId")
    public abstract List<ListProductImageResponseDto> productImageList(List<ProductImage> productImageList);
    @Mapping(source = "product.id", target="productId")
    public abstract ListProductImageResponseDto productImageList(ProductImage productImage);
    @Mapping(source = "product.id", target="productId")
    public abstract GetByIdProductImageResponseDto getByIdProductImageResponseDtoFromProductImage(ProductImage productImage);

}
