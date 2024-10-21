package com.etiya.productservice.mapper;

import com.etiya.productservice.entity.Category;
import com.etiya.productservice.service.dto.request.category.CreateCategoryRequestDto;
import com.etiya.productservice.service.dto.request.category.UpdateCategoryRequestDto;
import com.etiya.productservice.service.dto.responses.category.CreateCategoryResponseDto;
import com.etiya.productservice.service.dto.responses.category.GetByIdCategoryResponseDto;
import com.etiya.productservice.service.dto.responses.category.ListCategoryResponseDto;
import com.etiya.productservice.service.dto.responses.category.UpdateCategoryResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public abstract class CategoryMapper {

    @Mapping(target = "parentCategory.id", source = "parentCategoryId")
    public abstract Category categoryFromCreateCategoryRequestDto(CreateCategoryRequestDto createCategoryRequestDto);

    @Mapping(target = "parentCategoryId", source = "parentCategory.id")
    public abstract CreateCategoryResponseDto createCategoryResponseDtoFromCategory(Category category);

    @Mapping(target = "parentCategory.id", source = "parentCategoryId")
    public abstract Category categoryFromUpdateCategoryRequestDto(UpdateCategoryRequestDto updateCategoryRequestDto);

    @Mapping(target = "parentCategoryId", source = "parentCategory.id")
    public abstract UpdateCategoryResponseDto updateCategoryResponseDtoFromCategory(Category category);

    @Mapping(target = "parentCategoryId", source = "parentCategory.id")
    public abstract List<ListCategoryResponseDto> listCategoryResponseDtoListFromCategoryList(List<Category> categoryList);
    @Mapping(target = "parentCategoryId", source = "parentCategory.id")
    public abstract ListCategoryResponseDto categoryToCategoryResponseDto(Category category);
    @Mapping(target = "parentCategoryId", source = "parentCategory.id")
    public abstract GetByIdCategoryResponseDto getByIdCategoryResponseDtoFromCategory(Category category);

}
