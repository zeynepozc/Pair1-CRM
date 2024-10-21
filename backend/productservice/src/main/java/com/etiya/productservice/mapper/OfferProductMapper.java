package com.etiya.productservice.mapper;

import com.etiya.productservice.entity.OfferProduct;
import com.etiya.productservice.service.dto.request.offerProduct.*;
import com.etiya.productservice.service.dto.responses.offerProduct.*;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public abstract class OfferProductMapper {
    public abstract GetByIdOfferProductResponseDto getByIdOfferProductResponseDtoFromOfferProduct(OfferProduct offerProduct);
    public abstract OfferProduct offerProductFromCreateOfferProductRequestDto(CreateOfferProductRequestDto dto);
}
