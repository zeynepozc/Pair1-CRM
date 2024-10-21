package com.etiya.productservice.service.dto.request.offerProduct;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateOfferProductRequestDto {
    private Long id;
    private Long productId;
    private Long offerId;
}
