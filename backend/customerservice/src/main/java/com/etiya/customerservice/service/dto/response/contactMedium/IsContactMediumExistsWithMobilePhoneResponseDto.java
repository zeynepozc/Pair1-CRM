package com.etiya.customerservice.service.dto.response.contactMedium;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class IsContactMediumExistsWithMobilePhoneResponseDto {
    private boolean isExists;
}
