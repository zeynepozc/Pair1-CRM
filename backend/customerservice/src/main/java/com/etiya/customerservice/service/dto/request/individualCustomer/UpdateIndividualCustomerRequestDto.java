package com.etiya.customerservice.service.dto.request.individualCustomer;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateIndividualCustomerRequestDto {

    @NotEmpty
    private Long id;

    @NotEmpty
    private String firstName;
    @NotEmpty
    private String lastName;
    @NotBlank
    private String middleName;
    @NotEmpty
    private String fatherName;
    @NotEmpty
    private String motherName;
    @NotEmpty
    private String gender;
    @NotEmpty
    private LocalDate birthDate;
}
