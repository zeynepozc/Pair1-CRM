package com.etiya.productservice.service.concrete;

import com.etiya.productservice.entity.Category;
import com.etiya.productservice.mapper.CategoryMapper;
import com.etiya.productservice.repository.CategoryRepository;
import com.etiya.productservice.service.abstracts.CategoryService;
import com.etiya.productservice.service.dto.request.category.CreateCategoryRequestDto;
import com.etiya.productservice.service.dto.request.category.UpdateCategoryRequestDto;
import com.etiya.productservice.service.dto.responses.category.CreateCategoryResponseDto;
import com.etiya.productservice.service.dto.responses.category.GetByIdCategoryResponseDto;
import com.etiya.productservice.service.dto.responses.category.ListCategoryResponseDto;
import com.etiya.productservice.service.dto.responses.category.UpdateCategoryResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;


    @Override
    public List<ListCategoryResponseDto> getAll() {
        List<Category> categoryList = categoryRepository.findAll();
        return categoryMapper.listCategoryResponseDtoListFromCategoryList(categoryList);
    }

    @Override
    public GetByIdCategoryResponseDto getById(Long id) {
        Optional<Category> category = categoryRepository.findById(id);
        return categoryMapper.getByIdCategoryResponseDtoFromCategory(category.get());
    }

    @Override
    public CreateCategoryResponseDto add(CreateCategoryRequestDto createCategoryRequestDto) {
        Category category = categoryMapper.categoryFromCreateCategoryRequestDto(createCategoryRequestDto);
        return categoryMapper.createCategoryResponseDtoFromCategory(categoryRepository.save(category));
    }

    @Override
    public UpdateCategoryResponseDto update(UpdateCategoryRequestDto updateCategoryRequestDto) {
        Category category = categoryMapper.categoryFromUpdateCategoryRequestDto(updateCategoryRequestDto);
        category = categoryRepository.save(category);
        return categoryMapper.updateCategoryResponseDtoFromCategory(category);
    }

    @Override
    public void delete(Long id) {
        categoryRepository.deleteById(id);
    }
}
