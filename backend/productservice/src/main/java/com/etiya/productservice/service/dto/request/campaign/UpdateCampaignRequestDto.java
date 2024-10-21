package com.etiya.productservice.service.dto.request.campaign;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateCampaignRequestDto {
    private Long id;
    private String name;
    private String description;
    private Double discountValue;
    private boolean isActive;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
}
