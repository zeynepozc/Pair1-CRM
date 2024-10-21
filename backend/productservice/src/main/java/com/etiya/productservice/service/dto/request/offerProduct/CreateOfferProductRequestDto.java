package com.etiya.productservice.service.dto.request.offerProduct;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateOfferProductRequestDto {
    private Long productId;
    private Long offerId;
}
