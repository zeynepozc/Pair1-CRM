package com.etiya.customerservice.service.dto.response.customerAccount;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ListCustomerAccountResponseDto {
    private Long customerId;
    private String accountStatus;
    private String accountNumber;
    private String accountName;
    private String accountType;
    private String accountDescription;
}
