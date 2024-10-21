package com.etiya.customerservice.service.dto.request.district;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateDistrictRequestDto {
    @NotNull
    private Long id;
    @NotEmpty
    private String name;
    @NotNull
    private Long cityId;

}