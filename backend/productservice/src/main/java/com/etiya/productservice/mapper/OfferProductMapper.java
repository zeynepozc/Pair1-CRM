package com.etiya.productservice.mapper;

import com.etiya.productservice.entity.OfferProduct;
import com.etiya.productservice.service.dto.request.offerProduct.*;
import com.etiya.productservice.service.dto.responses.offerProduct.*;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public abstract class OfferProductMapper {

    public abstract GetByIdOfferProductResponseDto getByIdOfferProductResponseDtoFromOfferProduct(OfferProduct offerProduct);

    public abstract OfferProduct offerProductFromCreateOfferProductRequestDto(CreateOfferProductRequestDto dto);

    public abstract OfferProduct offerProductFromUpdateOfferProductRequestDto(UpdateOfferProductRequestDto dto);

    public abstract CreateOfferProductResponseDto createOfferProductResponseDtoFromOfferProduct(OfferProduct offerProduct);

    public abstract UpdateOfferProductResponseDto updateOfferProductResponseDtoFromOfferProduct(OfferProduct offerProduct);

    public abstract List<ListOfferProductResponseDto> offerProductListToListOfferProductResponseDto(List<OfferProduct> offerProducts);

    public abstract ListOfferProductResponseDto listOfferProductResponseDtoFromOfferProduct(OfferProduct offerProduct);
}
