package com.etiya.productservice.mapper;

import com.etiya.productservice.entity.Offer;
import com.etiya.productservice.service.dto.request.offer.CreateOfferRequestDto;
import com.etiya.productservice.service.dto.request.offer.UpdateOfferRequestDto;
import com.etiya.productservice.service.dto.responses.offer.CreateOfferResponseDto;
import com.etiya.productservice.service.dto.responses.offer.GetByIdOfferResponseDto;
import com.etiya.productservice.service.dto.responses.offer.ListOfferResponseDto;
import com.etiya.productservice.service.dto.responses.offer.UpdateOfferResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;


@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public abstract class OfferMapper {
    public abstract Offer offerFromCreateOfferRequestDto(CreateOfferRequestDto dto);

    public abstract CreateOfferResponseDto createOfferResponseDtoFromOffer(Offer offer);

    public abstract Offer offerFromUpdateOfferRequestDto(UpdateOfferRequestDto dto);

    public abstract UpdateOfferResponseDto updateOfferResponseDtoFromOffer(Offer offer);
    public abstract GetByIdOfferResponseDto getByIdOfferResponseDtoFromOffer(Offer offer);
    public abstract List<ListOfferResponseDto> offerList(List<Offer> offers);
}

