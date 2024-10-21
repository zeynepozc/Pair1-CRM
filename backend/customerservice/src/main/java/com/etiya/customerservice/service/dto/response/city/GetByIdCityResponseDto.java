package com.etiya.customerservice.service.dto.response.city;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetByIdCityResponseDto {
    public String name;
    public Short countryId;
}
