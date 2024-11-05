package com.etiya.customerservice.service.dto.response.individualCustomer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SearchIndividualCustomerResponseDto {
    private String natID;
    private Long customerId;
    private String firstName;
    private String lastName;
    private String phoneNo;
    private String email;
    private Boolean isActive;
    private LocalDateTime createdDate;
}
