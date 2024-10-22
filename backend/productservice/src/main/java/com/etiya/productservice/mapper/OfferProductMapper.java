package com.etiya.productservice.mapper;

import com.etiya.productservice.entity.OfferProduct;
import com.etiya.productservice.service.dto.request.offerProduct.*;
import com.etiya.productservice.service.dto.responses.offerProduct.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public abstract class OfferProductMapper {

    @Mapping(target = "productId", source = "product.id")
    @Mapping(target = "offerId", source = "offer.id")
    public abstract GetByIdOfferProductResponseDto getByIdOfferProductResponseDtoFromOfferProduct(OfferProduct offerProduct);

    @Mapping(target = "product.id", source = "productId")
    @Mapping(target = "offer.id", source = "offerId")
    public abstract OfferProduct offerProductFromCreateOfferProductRequestDto(CreateOfferProductRequestDto dto);

    @Mapping(target = "product.id", source = "productId")
    @Mapping(target = "offer.id", source = "offerId")
    public abstract OfferProduct offerProductFromUpdateOfferProductRequestDto(UpdateOfferProductRequestDto dto);

    @Mapping(target = "productId", source = "product.id")
    @Mapping(target = "offerId", source = "offer.id")
    public abstract CreateOfferProductResponseDto createOfferProductResponseDtoFromOfferProduct(OfferProduct offerProduct);

    @Mapping(target = "productId", source = "product.id")
    @Mapping(target = "offerId", source = "offer.id")
    public abstract UpdateOfferProductResponseDto updateOfferProductResponseDtoFromOfferProduct(OfferProduct offerProduct);

    @Mapping(target = "productId", source = "product.id")
    @Mapping(target = "offerId", source = "offer.id")
    public abstract List<ListOfferProductResponseDto> offerProductListToListOfferProductResponseDto(List<OfferProduct> offerProducts);

    @Mapping(target = "productId", source = "product.id")
    @Mapping(target = "offerId", source = "offer.id")
    public abstract ListOfferProductResponseDto listOfferProductResponseDtoFromOfferProduct(OfferProduct offerProduct);
}
