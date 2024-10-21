package com.etiya.productservice.service.dto.responses.category;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateCategoryResponseDto {
    private Long id;
    private String name;
    private Long parentCategoryId;
}
