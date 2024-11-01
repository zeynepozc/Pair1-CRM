package com.etiya.customerservice.service.dto.request.address;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateAddressRequestDto {
    private Long customerId;
    private String name;
    private String city;
    private String district;
    private String neighborhood;
    private String postalCode;
    private String houseNo;
    private String description;
}
