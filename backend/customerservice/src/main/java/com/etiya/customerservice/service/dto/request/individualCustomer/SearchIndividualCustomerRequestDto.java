package com.etiya.customerservice.service.dto.request.individualCustomer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SearchIndividualCustomerRequestDto {
    private String natId;
    private Long customerId;
    private String firstName;
    private String lastName;
    private String phoneNo;
    private String email;
    private boolean isActive;
    private LocalDateTime createdDate;
}
