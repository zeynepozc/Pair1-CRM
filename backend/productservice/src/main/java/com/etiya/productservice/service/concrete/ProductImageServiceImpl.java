package com.etiya.productservice.service.concrete;

import com.etiya.productservice.entity.ProductImage;
import com.etiya.productservice.mapper.ProductImageMapper;
import com.etiya.productservice.repository.ProductImageRepository;
import com.etiya.productservice.service.abstracts.ProductImageService;
import com.etiya.productservice.service.dto.request.productImage.CreateProductImageRequestDto;
import com.etiya.productservice.service.dto.request.productImage.UpdateProductImageRequestDto;
import com.etiya.productservice.service.dto.responses.productImage.CreateProductImageResponseDto;
import com.etiya.productservice.service.dto.responses.productImage.GetByIdProductImageResponseDto;
import com.etiya.productservice.service.dto.responses.productImage.ListProductImageResponseDto;
import com.etiya.productservice.service.dto.responses.productImage.UpdateProductImageResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductImageServiceImpl implements ProductImageService {
    private final ProductImageRepository productImageRepository;
    private final ProductImageMapper productImageMapper;

    @Override
    public List<ListProductImageResponseDto> getAll() {
        List<ProductImage> productImages = productImageRepository.findAll();
        return productImageMapper.productImageList(productImages);
    }

    @Override
    public GetByIdProductImageResponseDto getById(Long id) {
        ProductImage productImage = productImageRepository.findById(id).orElseThrow();
        return productImageMapper.getByIdProductImageResponseDtoFromProductImage(productImage);
    }

    @Override
    public CreateProductImageResponseDto add(CreateProductImageRequestDto createProductImageRequestDto) {
        ProductImage productImage = productImageMapper.productImageFromCreateProductImageRequestDto(createProductImageRequestDto);
        ProductImage addedProductImage = productImageRepository.save(productImage);
        return productImageMapper.createProductImageResponseDtoFromProductImage(addedProductImage);
    }

    @Override
    public void delete(Long id) {
        productImageRepository.deleteById(id);
    }

    @Override
    public UpdateProductImageResponseDto update(Long id, UpdateProductImageRequestDto updateProductImageRequestDto) {
        ProductImage productImage = productImageMapper.productImageFromUpdateProductImageRequestDto(updateProductImageRequestDto);
        productImage.setId(id);
        ProductImage updatedProductImage = productImageRepository.save(productImage);
        return productImageMapper.updateProductImageResponseDtoFromProductImage(updatedProductImage);
    }
}
