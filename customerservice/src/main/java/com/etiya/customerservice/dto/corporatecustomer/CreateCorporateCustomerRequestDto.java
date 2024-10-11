package com.etiya.customerservice.dto.corporatecustomer;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateCorporateCustomerRequestDto {

    @NotEmpty
    private String companyName;

    @NotEmpty
    private String companyNumber;

    @NotEmpty
    private String taxNumber;
}
