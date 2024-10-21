package com.etiya.productservice.service.concrete;

import com.etiya.productservice.entity.Offer;
import com.etiya.productservice.mapper.OfferMapper;
import com.etiya.productservice.repository.OfferRepository;
import com.etiya.productservice.service.abstracts.OfferService;
import com.etiya.productservice.service.dto.request.offer.CreateOfferRequestDto;
import com.etiya.productservice.service.dto.request.offer.UpdateOfferRequestDto;
import com.etiya.productservice.service.dto.responses.offer.CreateOfferResponseDto;
import com.etiya.productservice.service.dto.responses.offer.GetByIdOfferResponseDto;
import com.etiya.productservice.service.dto.responses.offer.ListOfferResponseDto;
import com.etiya.productservice.service.dto.responses.offer.UpdateOfferResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OfferServiceImpl implements OfferService {
    private final OfferRepository offerRepository;
    private final OfferMapper offerMapper;

    @Override
    public GetByIdOfferResponseDto getById(Long id) {
        Offer offer = offerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Offer not found with id: " + id));
        return offerMapper.getByIdOfferResponseDtoFromOffer(offer);
    }
    @Override
    public List<ListOfferResponseDto> getAll() {
        List<Offer> offers = offerRepository.findAll();
        return offerMapper.offerList(offers);
    }

    @Override
    public CreateOfferResponseDto add(CreateOfferRequestDto createOfferRequestDto) {
        Offer offer = offerMapper.offerFromCreateOfferRequestDto(createOfferRequestDto);
        Offer addedOffer = offerRepository.save(offer);
        return offerMapper.createOfferResponseDtoFromOffer(addedOffer);
    }

    @Override
    public UpdateOfferResponseDto update(UpdateOfferRequestDto updateOfferRequestDto) {
        Offer offer = offerMapper.offerFromUpdateOfferRequestDto(updateOfferRequestDto);
        offer.setId(updateOfferRequestDto.getId());
        Offer updatedOffer = offerRepository.save(offer);
        return offerMapper.updateOfferResponseDtoFromOffer(updatedOffer);
    }

    @Override
    public void delete(Long id) {
        offerRepository.deleteById(id);
    }

    @Override
    public List<ListOfferResponseDto> search(List<Long> ids) {
        List<Offer> offers = offerRepository.findAllById(ids);
        return offerMapper.offerList(offers);
    }
}

