package com.etiya.customerservice.service.dto.response.individualCustomer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class IsCustomerExistsWithNatIDResponseDto {
    private Boolean isExists;
}
