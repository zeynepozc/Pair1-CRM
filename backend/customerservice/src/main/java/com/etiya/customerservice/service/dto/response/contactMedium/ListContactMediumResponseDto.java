package com.etiya.customerservice.service.dto.response.contactMedium;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ListContactMediumResponseDto {
    private Long id;
    private Long customerId;
    private String email;
    private String homePhone;
    private String mobilePhone;
    private String fax;
}
