package com.etiya.productservice.mapper;

import com.etiya.productservice.service.dto.request.product.UpdateProductRequestDto;
import com.etiya.productservice.service.dto.responses.product.CreateProductResponseDto;
import com.etiya.productservice.service.dto.request.product.CreateProductRequestDto;
import com.etiya.productservice.service.dto.responses.product.GetByIdProductResponseDto;
import com.etiya.productservice.service.dto.responses.product.ListProductResponseDto;
import com.etiya.productservice.entity.Product;
import com.etiya.productservice.service.dto.responses.product.UpdateProductResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public abstract class ProductMapper {
    
    @Mapping(source="categoryId", target = "category.id")
    public abstract Product productFromCreateProductRequestDto(CreateProductRequestDto dto);

    @Mapping(source="categoryId", target = "category.id")
    public abstract Product productFromUpdateProductRequestDto(UpdateProductRequestDto dto);

    @Mapping(source="category.id", target = "categoryId")
    public abstract CreateProductResponseDto createProductResponseDtoFromProduct(Product product);

    @Mapping(source="category.id", target = "categoryId")
    public abstract GetByIdProductResponseDto getByIdProductResponseDtoFromProduct(Product product);

    @Mapping(source="category.id", target = "categoryId")
    public abstract UpdateProductResponseDto updateProductResponseDtoFromProduct(Product product);

    @Mapping(source="category.id", target = "categoryId")
    public abstract List<ListProductResponseDto> listProductResponseDtoListFromProductList(List<Product> product);

    @Mapping(source="category.id", target = "categoryId")
    public abstract ListProductResponseDto productToListProductResponseDto(Product product);

}