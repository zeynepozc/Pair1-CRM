package com.etiya.customerservice.service.dto.request.neighborhood;

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
public class UpdateNeighborhoodRequestDto {
    @NotEmpty
    private Long id;
    @NotEmpty
    private String name;
    @NotEmpty
    private String houseNo;
    @NotNull
    private Long districtId;
}
