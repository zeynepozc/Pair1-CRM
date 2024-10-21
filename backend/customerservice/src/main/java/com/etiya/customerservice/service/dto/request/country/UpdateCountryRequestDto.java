package com.etiya.customerservice.service.dto.request.country;

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
public class UpdateCountryRequestDto {
    @NotNull
    private Short id;

    @NotEmpty
    private String name;
}
