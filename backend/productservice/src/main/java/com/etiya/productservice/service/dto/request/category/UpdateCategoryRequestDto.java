package com.etiya.productservice.service.dto.request.category;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateCategoryRequestDto {
    @NotEmpty
    private Long id;
    @NotEmpty
    private String name;
    private Long parentCategoryId;
}
