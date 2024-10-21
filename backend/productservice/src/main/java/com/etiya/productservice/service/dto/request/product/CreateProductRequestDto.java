package com.etiya.productservice.service.dto.request.product;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateProductRequestDto {
    @NotEmpty
    private String name;

    @Positive
    private Long categoryId;

    @NotEmpty
    private String description;

    @Positive
    private BigDecimal price;

    @PositiveOrZero
    private int stockQuantity;

    private boolean isActive;
}
