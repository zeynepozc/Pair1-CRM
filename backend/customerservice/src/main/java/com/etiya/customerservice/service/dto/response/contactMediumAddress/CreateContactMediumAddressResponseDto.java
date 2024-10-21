package com.etiya.customerservice.service.dto.response.contactMediumAddress;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateContactMediumAddressResponseDto {
    private Long id;
    private Long contactMediumId;
    private Long contactAddressId;
}
