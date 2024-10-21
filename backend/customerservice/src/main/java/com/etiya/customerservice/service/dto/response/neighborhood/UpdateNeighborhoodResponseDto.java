package com.etiya.customerservice.service.dto.response.neighborhood;

import com.etiya.customerservice.entity.District;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateNeighborhoodResponseDto {
    private Long id;
    private String name;
    private String postalCode;
    private String houseNo;
    private Long districtId;
}
