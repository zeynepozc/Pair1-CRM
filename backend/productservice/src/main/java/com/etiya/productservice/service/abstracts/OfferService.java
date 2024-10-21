package com.etiya.productservice.service.abstracts;


import com.etiya.productservice.service.dto.request.offer.CreateOfferRequestDto;
import com.etiya.productservice.service.dto.request.offer.UpdateOfferRequestDto;
import com.etiya.productservice.service.dto.responses.offer.CreateOfferResponseDto;
import com.etiya.productservice.service.dto.responses.offer.GetByIdOfferResponseDto;
import com.etiya.productservice.service.dto.responses.offer.ListOfferResponseDto;
import com.etiya.productservice.service.dto.responses.offer.UpdateOfferResponseDto;

import java.util.List;

public interface OfferService {
    List<ListOfferResponseDto> getAll();
    GetByIdOfferResponseDto getById(Long id);
    CreateOfferResponseDto add(CreateOfferRequestDto createOfferRequestDTO);
    UpdateOfferResponseDto update(UpdateOfferRequestDto updateOfferRequestDTO);
    void delete(Long id);
    List<ListOfferResponseDto> search(List<Long> ids);
}

