package com.etiya.customerservice.service.dto.request.contactMediumAddress;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateContactMediumAddressRequestDto {
    @NotNull
    private Long id;

    @NotNull
    private Long contactMediumId;

    @NotNull
    private Long contactAddressId;
}
