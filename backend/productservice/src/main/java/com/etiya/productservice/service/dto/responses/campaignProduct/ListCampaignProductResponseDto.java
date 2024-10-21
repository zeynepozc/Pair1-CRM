package com.etiya.productservice.service.dto.responses.campaignProduct;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ListCampaignProductResponseDto {
    private Long id;
    private Long productId;
    private Long campaignId;
}
