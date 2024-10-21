package com.etiya.productservice.service.concrete;

import com.etiya.productservice.service.dto.request.productAttribute.CreateProductAttributeRequestDto;
import com.etiya.productservice.service.dto.request.productAttribute.UpdateProductAttributeRequestDto;
import com.etiya.productservice.service.dto.responses.productAttribute.CreateProductAttributeResponseDto;
import com.etiya.productservice.service.dto.responses.productAttribute.GetByIdProductAttributeResponseDto;
import com.etiya.productservice.service.dto.responses.productAttribute.ListProductAttributeResponseDto;
import com.etiya.productservice.service.dto.responses.productAttribute.UpdateProductAttributeResponseDto;
import com.etiya.productservice.mapper.ProductAttributeMapper;
import com.etiya.productservice.repository.ProductAttributeRepository;
import com.etiya.productservice.service.abstracts.ProductAttributeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.etiya.productservice.entity.ProductAttribute;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductAttributeServiceImpl implements ProductAttributeService {

    private final ProductAttributeRepository productAttributeRepository;
    private final ProductAttributeMapper productAttributeMapper;

    @Override
    public List<ListProductAttributeResponseDto> getAll() {
        List<ProductAttribute> productAttributes = productAttributeRepository.findAll();
        return productAttributeMapper.productAttributeList(productAttributes);
    }

    @Override
    public GetByIdProductAttributeResponseDto getById(Long id) {
        ProductAttribute productAttribute = productAttributeRepository.findById(id).orElseThrow();
        return productAttributeMapper.getByIdProductAttributeResponseDtoFromProductAttribute(productAttribute);
    }

    @Override
    public CreateProductAttributeResponseDto add(CreateProductAttributeRequestDto createProductAttributeRequestDto) {
        ProductAttribute productAttribute = productAttributeMapper.productAttributeFromCreateProductAttributeRequestDto(createProductAttributeRequestDto);
        ProductAttribute addedProductAttribute = productAttributeRepository.save(productAttribute);
        return productAttributeMapper.createProductAttributeResponseDtoFromProductAttribute(addedProductAttribute);
    }

    @Override
    public void delete(Long id) {
        productAttributeRepository.deleteById(id);
    }

    @Override
    public UpdateProductAttributeResponseDto update(Long id, UpdateProductAttributeRequestDto updateProductAttributeRequestDto) {
        ProductAttribute productAttribute = productAttributeMapper.productAttributeFromUpdateProductAttributeRequestDto(updateProductAttributeRequestDto);
        productAttribute.setId(id);
        ProductAttribute updatedProductAttribute = productAttributeRepository.save(productAttribute);
        return productAttributeMapper.updateProductAttributeResponseDtoFromProductAttribute(updatedProductAttribute);
    }
}
