package com.etiya.productservice.service.dto.responses.attributeValue;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetByIdAttributeValueResponseDto {
    private Long id;
    private Long attributeId;
    private String value;
    private boolean isActive;
}
