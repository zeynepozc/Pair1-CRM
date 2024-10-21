package com.etiya.productservice.service.concrete;

import com.etiya.productservice.service.dto.request.product.CreateProductRequestDto;
import com.etiya.productservice.service.dto.request.product.UpdateProductRequestDto;
import com.etiya.productservice.service.dto.responses.product.CreateProductResponseDto;
import com.etiya.productservice.service.dto.responses.product.GetByIdProductResponseDto;
import com.etiya.productservice.service.dto.responses.product.ListProductResponseDto;
import com.etiya.productservice.entity.Product;
import com.etiya.productservice.mapper.ProductMapper;
import com.etiya.productservice.repository.ProductRepository;
import com.etiya.productservice.service.abstracts.ProductService;
import com.etiya.productservice.service.dto.responses.product.UpdateProductResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService
{
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;


    @Override
    public List<ListProductResponseDto> getAll() {
        List<Product> productList = productRepository.findAll();
        return productMapper.listProductResponseDtoListFromProductList(productList);
    }

    @Override
    public GetByIdProductResponseDto getById(Long id) {
        Optional<Product> product = productRepository.findById(id);
        return productMapper.getByIdProductResponseDtoFromProduct(product.get());
    }

    @Override
    public CreateProductResponseDto add(CreateProductRequestDto createProductRequestDto) {
        Product product = productMapper.productFromCreateProductRequestDto(createProductRequestDto);
        return productMapper.createProductResponseDtoFromProduct(productRepository.save(product));
    }

    @Override
    public UpdateProductResponseDto update(UpdateProductRequestDto updateProductRequestDto) {
        Product product = productMapper.productFromUpdateProductRequestDto(updateProductRequestDto);
        product = productRepository.save(product);
        return productMapper.updateProductResponseDtoFromProduct(product);
    }

    @Override
    public void delete(Long id) {
        productRepository.deleteById(id);
    }
}
