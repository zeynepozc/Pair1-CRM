package com.etiya.customerservice.service.dto.response.contactAddress;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateContactAddressResponseDto {
    private Long id;
    private String name;
    private String addressDesc;
    private Long neighborhoodId;
}
