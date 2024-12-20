package com.etiya.customerservice.service.dto.response.corporateCustomer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetByIdCorporateCustomerResponseDto {
    private String companyName;
    private String companyNumber;
    private String taxNumber;
}
