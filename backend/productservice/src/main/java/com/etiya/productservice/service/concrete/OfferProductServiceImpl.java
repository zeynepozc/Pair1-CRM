package com.etiya.productservice.service.concrete;

import com.etiya.productservice.entity.OfferProduct;
import com.etiya.productservice.mapper.OfferProductMapper;
import com.etiya.productservice.repository.OfferProductRepository;
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
    private final OfferProductMapper offerProductMapper;

    @Override
    public GetByIdOfferProductResponseDto getById(Long id) {
        OfferProduct offerProduct = offerProductRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("OfferProduct not found with id: " + id));
        return offerProductMapper.getByIdOfferProductResponseDtoFromOfferProduct(offerProduct);
    }

    @Override
    public List<ListOfferProductResponseDto> getAll() {
        List<OfferProduct> offerProducts = offerProductRepository.findAll();
        return offerProductMapper.offerProductListToListOfferProductResponseDto(offerProducts);
    }

    @Override
    public CreateOfferProductResponseDto add(CreateOfferProductRequestDto createOfferProductRequestDto) {
        // todo
        OfferProduct offerProduct = offerProductMapper.offerProductFromCreateOfferProductRequestDto(createOfferProductRequestDto);
        OfferProduct addedOfferProduct = offerProductRepository.save(offerProduct);
        return offerProductMapper.createOfferProductResponseDtoFromOfferProduct(addedOfferProduct);
    }


    @Override
    public UpdateOfferProductResponseDto update(Long id, UpdateOfferProductRequestDto updateOfferProductRequestDto) {
        OfferProduct offerProduct = offerProductMapper.offerProductFromUpdateOfferProductRequestDto(updateOfferProductRequestDto);
        offerProduct.setId(id);
        OfferProduct updatedOfferProduct = offerProductRepository.save(offerProduct);
        return offerProductMapper.updateOfferProductResponseDtoFromOfferProduct(updatedOfferProduct);
    }

    @Override
    public void delete(Long id) {
        offerProductRepository.deleteById(id);
    }
}
