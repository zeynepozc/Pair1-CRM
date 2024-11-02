package com.etiya.customerservice.service.dto.request.individualCustomer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class IsCustomerExistsWithNatIDRequestDto {
    private String natID;
}
