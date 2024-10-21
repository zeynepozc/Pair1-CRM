package com.etiya.productservice.service.concrete;

import com.etiya.productservice.entity.Offer;
import com.etiya.productservice.entity.OfferProduct;
import com.etiya.productservice.entity.Product;
import com.etiya.productservice.mapper.OfferProductMapper;
import com.etiya.productservice.repository.OfferProductRepository;
import com.etiya.productservice.repository.OfferRepository;
import com.etiya.productservice.repository.ProductRepository;
import com.etiya.productservice.service.abstracts.OfferProductService;
import com.etiya.productservice.service.dto.request.offerProduct.*;
import com.etiya.productservice.service.dto.responses.offerProduct.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OfferProductServiceImpl implements OfferProductService {

    private final OfferProductRepository offerProductRepository;
    private final ProductRepository productRepository;
    private final OfferRepository offerRepository;
    private final OfferProductMapper offerProductMapper;


    @Override
    public GetByIdOfferProductResponseDto getById(Long id) {
        OfferProduct offerProduct = offerProductRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("OfferProduct not found with id: " + id));
        return offerProductMapper.getByIdOfferProductResponseDtoFromOfferProduct(offerProduct);
    }

    @Override
    public List<GetByIdOfferProductResponseDto> getAll() {
        return offerProductRepository.findAll().stream()
                .map(offerProductMapper::getByIdOfferProductResponseDtoFromOfferProduct)
                .collect(Collectors.toList());
    }

    @Override
    public void add(CreateOfferProductRequestDto createOfferProductRequestDto) {
        Product product = productRepository.findById(createOfferProductRequestDto.getProductId())
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + createOfferProductRequestDto.getProductId()));
        Offer offer = offerRepository.findById(createOfferProductRequestDto.getOfferId())
                .orElseThrow(() -> new RuntimeException("Offer not found with id: " + createOfferProductRequestDto.getOfferId()));

        OfferProduct offerProduct = new OfferProduct();
        offerProduct.setProduct(product);
        offerProduct.setOffer(offer);
        offerProductRepository.save(offerProduct);
    }

    @Override
    public void delete(Long id) {
        offerProductRepository.deleteById(id);
    }
}
