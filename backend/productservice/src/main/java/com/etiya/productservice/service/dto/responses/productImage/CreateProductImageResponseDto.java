package com.etiya.productservice.service.dto.responses.productImage;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateProductImageResponseDto {
    private Long id;
    private Long productId;
    private String imageUrl;
}
