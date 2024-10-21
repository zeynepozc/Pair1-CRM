package com.etiya.customerservice.service.dto.request.city;

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
public class CreateCityRequestDto {
    @NotEmpty
    private String city;

    @NotNull
    private Short countryId;
}
