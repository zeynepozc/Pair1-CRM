package com.etiya.customerservice.service.dto.request.contactMedium;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class IsContactMediumExistsWithEmailRequestDto {
    @NotEmpty
    private String email;
}
