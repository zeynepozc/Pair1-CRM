package com.etiya.productservice.service.dto.responses.productAttribute;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ListProductAttributeResponseDto {
    private Long id;
    private String name;
    private String dataType;
}