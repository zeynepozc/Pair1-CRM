package com.etiya.customerservice.service.dto.response.district;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateDistrictResponseDto {
    private Long id;
    private String name;
    private Long cityId;
}
