package com.etiya.productservice.service.dto.request.attributeValue;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateAttributeValueRequestDto {
    private Long attributeId;
    private String value;
}
