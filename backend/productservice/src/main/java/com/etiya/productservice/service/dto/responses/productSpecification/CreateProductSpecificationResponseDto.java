package com.etiya.productservice.service.dto.responses.productSpecification;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateProductSpecificationResponseDto{
    private Long id;
    private Long productId;
    private Long attributeValueId;
}
