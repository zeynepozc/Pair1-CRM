package com.etiya.customerservice.service.dto.request.individualCustomer;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateIndividualCustomerRequestDto {

    @NotEmpty
    @Size(min = 11, max = 11)
    private String natID;

    @NotEmpty
    private String firstName;
    @NotEmpty
    private String lastName;

    private String middleName;
    @NotEmpty
    private String fatherName;
    @NotEmpty
    private String motherName;
    @NotEmpty
    private String gender;

    @NotNull(message = "Birth date is required.")
    @Past(message = "Birth date must be a date in the past.")
    private LocalDate birthDate;

}
