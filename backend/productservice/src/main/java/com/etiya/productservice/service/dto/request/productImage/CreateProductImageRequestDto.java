package com.etiya.productservice.service.dto.request.productImage;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateProductImageRequestDto {
    private Long productId;
    private String imageUrl;
}
