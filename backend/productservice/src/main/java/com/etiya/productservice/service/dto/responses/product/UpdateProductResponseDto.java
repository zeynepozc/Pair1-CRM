package com.etiya.productservice.service.dto.responses.product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateProductResponseDto {
    private Long id;
    private String name;
    private Long categoryId;
    private String description;
    private BigDecimal price;
    private int stockQuantity;
    private boolean isActive;
}
