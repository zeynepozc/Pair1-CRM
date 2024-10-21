package com.etiya.productservice.service.concrete;

import com.etiya.productservice.entity.ProductSpecification;
import com.etiya.productservice.mapper.ProductSpecificationMapper;
import com.etiya.productservice.repository.ProductSpecificationRepository;
import com.etiya.productservice.service.abstracts.ProductSpecificationService;
import com.etiya.productservice.service.dto.request.productSpecification.CreateProductSpecificationRequestDto;
import com.etiya.productservice.service.dto.request.productSpecification.UpdateProductSpecificationRequestDto;
import com.etiya.productservice.service.dto.responses.productSpecification.CreateProductSpecificationResponseDto;
import com.etiya.productservice.service.dto.responses.productSpecification.GetByIdProductSpecificationResponseDto;
import com.etiya.productservice.service.dto.responses.productSpecification.ListProductSpecificationResponseDto;
import com.etiya.productservice.service.dto.responses.productSpecification.UpdateProductSpecificationResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductSpecificationServiceImpl implements ProductSpecificationService {
    private final ProductSpecificationRepository productSpecificationRepository;
    private final ProductSpecificationMapper productSpecificationMapper;

    @Override
    public List<ListProductSpecificationResponseDto> getAll() {
        List<ProductSpecification> productSpecifications = productSpecificationRepository.findAll();
        return productSpecificationMapper.productSpecificationList(productSpecifications);
    }

    @Override
    public GetByIdProductSpecificationResponseDto getById(Long id) {
        ProductSpecification productSpecification = productSpecificationRepository.findById(id).orElseThrow();
        return productSpecificationMapper.getByIdProductSpecificationResponseDtoFromProductSpecification(productSpecification);
    }

    @Override
    public CreateProductSpecificationResponseDto add(CreateProductSpecificationRequestDto createProductSpecificationRequestDto) {
        ProductSpecification productSpecification = productSpecificationMapper.productSpecificationFromCreateProductSpecificationRequestDto(createProductSpecificationRequestDto);
        ProductSpecification addedProductSpecification = productSpecificationRepository.save(productSpecification);
        return productSpecificationMapper.createProductSpecificationResponseDtoFromProductSpecification(addedProductSpecification);
    }

    @Override
    public void delete(Long id) {
        productSpecificationRepository.deleteById(id);
    }

    @Override
    public UpdateProductSpecificationResponseDto update(Long id, UpdateProductSpecificationRequestDto updateProductSpecificationRequestDto) {
        ProductSpecification productSpecification = productSpecificationMapper.productSpecificationFromUpdateProductSpecificationRequestDto(updateProductSpecificationRequestDto);
        productSpecification.setId(id);
        ProductSpecification updatedProductSpecification = productSpecificationRepository.save(productSpecification);
        return productSpecificationMapper.updateProductSpecificationResponseDtoFromProductSpecification(updatedProductSpecification);
    }
}
