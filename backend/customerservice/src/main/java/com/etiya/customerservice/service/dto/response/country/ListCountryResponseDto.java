package com.etiya.customerservice.service.dto.response.country;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ListCountryResponseDto {
    private Short id;
    private String name;
}