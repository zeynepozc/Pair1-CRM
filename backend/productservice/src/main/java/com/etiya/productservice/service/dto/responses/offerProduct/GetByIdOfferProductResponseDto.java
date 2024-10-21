package com.etiya.productservice.service.dto.responses.offerProduct;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetByIdOfferProductResponseDto {
    private Long id;
    private Long productId;
    private Long offerId;
}
