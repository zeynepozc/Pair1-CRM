package com.etiya.productservice.service.dto.request.offer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateOfferRequestDto {
    private String description;
    private Double discountValue;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
}
