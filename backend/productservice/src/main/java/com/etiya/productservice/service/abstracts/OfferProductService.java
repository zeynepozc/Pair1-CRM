package com.etiya.productservice.service.abstracts;

import com.etiya.productservice.service.dto.request.offerProduct.*;
import com.etiya.productservice.service.dto.responses.offerProduct.*;

import java.util.List;

public interface OfferProductService {
    GetByIdOfferProductResponseDto getById(Long id);
    List<ListOfferProductResponseDto> getAll();
    CreateOfferProductResponseDto add(CreateOfferProductRequestDto createOfferProductRequestDto);
    void delete(Long id);
    public UpdateOfferProductResponseDto update(Long id, UpdateOfferProductRequestDto updateOfferProductRequestDto);
}
