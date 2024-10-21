package com.etiya.productservice.service.abstracts;

import com.etiya.productservice.service.dto.request.offerProduct.CreateOfferProductRequestDto;
import com.etiya.productservice.service.dto.responses.offerProduct.GetByIdOfferProductResponseDto;

import java.util.List;

public interface OfferProductService {
    GetByIdOfferProductResponseDto getById(Long id);
    List<GetByIdOfferProductResponseDto> getAll();
    void add(CreateOfferProductRequestDto createOfferProductRequestDto);
    void delete(Long id);
}
