package com.etiya.customerservice.service.dto.request.contactMedium;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class IsContactMediumExistsWithMobilePhoneRequestDto {
    private String mobilePhone;
}
