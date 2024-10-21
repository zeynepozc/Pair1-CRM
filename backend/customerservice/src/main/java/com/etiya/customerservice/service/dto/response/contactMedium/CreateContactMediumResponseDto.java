package com.etiya.customerservice.service.dto.response.contactMedium;

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
public class CreateContactMediumResponseDto {
    private Long id;
    private Long customerId;
    private String email;
    private String homePhone;
    private String mobilePhone;
    private String fax;
}
