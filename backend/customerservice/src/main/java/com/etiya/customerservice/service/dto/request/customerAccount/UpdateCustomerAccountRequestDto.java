package com.etiya.customerservice.service.dto.request.customerAccount;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCustomerAccountRequestDto {
    @NotNull
    private Long id;

    @NotNull
    private Long customerId;

    @NotEmpty
    private String accountStatus;

    @NotEmpty
    private String accountNumber;

    @NotEmpty
    private String accountName;

    @NotEmpty
    private String accountType;

    @NotEmpty
    private String action;

    @NotEmpty
    private String accountDescription;
}
