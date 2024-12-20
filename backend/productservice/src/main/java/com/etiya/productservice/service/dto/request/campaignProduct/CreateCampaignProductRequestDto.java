package com.etiya.productservice.service.dto.request.campaignProduct;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateCampaignProductRequestDto {
    private Long productId;
    private Long campaignId;
}
