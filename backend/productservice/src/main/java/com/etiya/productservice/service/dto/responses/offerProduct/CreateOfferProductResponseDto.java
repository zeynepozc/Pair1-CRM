package com.etiya.productservice.service.dto.responses.offerProduct;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateOfferProductResponseDto {
    private Long id;
    private Long productId;
    private Long offerId;
}
