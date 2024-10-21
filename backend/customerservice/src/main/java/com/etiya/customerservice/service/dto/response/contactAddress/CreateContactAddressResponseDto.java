package com.etiya.customerservice.service.dto.response.contactAddress;


import com.etiya.customerservice.entity.Neighborhood;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateContactAddressResponseDto {
    private Long id;
    private String addressDesc;
    private Long neighborhoodId;
}
