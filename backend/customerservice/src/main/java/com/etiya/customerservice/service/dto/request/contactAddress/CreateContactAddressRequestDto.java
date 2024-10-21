package com.etiya.customerservice.service.dto.request.contactAddress;

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
public class CreateContactAddressRequestDto {
    @NotEmpty
    private String addressDesc;

    @NotNull
    private Long neighborhoodId;
}

