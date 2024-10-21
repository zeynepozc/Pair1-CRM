package com.etiya.customerservice.service.dto.request.contactMedium;

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
public class CreateContactMediumRequestDto {
    @NotNull
    private Long customerId;

    @NotEmpty
    private String email;

    private String homePhone;

    @NotEmpty
    private String mobilePhone;

    private String fax;

}
