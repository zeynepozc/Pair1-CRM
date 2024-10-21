package com.etiya.productservice.service.dto.responses.offer;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateOfferResponseDto {
    private Long id;
    private String description;
    private Double discountValue;
    private boolean isActive; // isActive statusu
    private LocalDateTime startDate;
    private LocalDateTime endDate;
}
