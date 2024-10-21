package com.etiya.productservice.service.dto.request.productSpecification;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateProductSpecificationRequestDto {
    private Long productId;
    private Long attributeValueId;
}
