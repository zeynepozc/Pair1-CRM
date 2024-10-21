package com.etiya.customerservice.service.dto.response.neighborhood;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateNeighborhoodResponseDto {
    private Long id;
    private String name;
    private String postalCode;
    private String houseNo;
    private Long districtId;
}
