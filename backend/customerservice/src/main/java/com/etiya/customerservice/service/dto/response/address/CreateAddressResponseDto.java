package com.etiya.customerservice.service.dto.response.address;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateAddressResponseDto {
    private Long customer;
    private String name;
    private String city;
    private String district;
    private String neighborhood;
    private String postalCode;
    private String houseNo;
    private String description;
}
