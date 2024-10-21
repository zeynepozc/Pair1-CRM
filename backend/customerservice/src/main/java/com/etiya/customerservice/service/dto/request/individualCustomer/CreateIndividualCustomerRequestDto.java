package com.etiya.customerservice.service.dto.request.individualCustomer;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
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
    @NotBlank
    private String middleName;
    @NotEmpty
    private String fatherName;
    @NotEmpty
    private String motherName;
    @NotEmpty
    private String gender;

    private LocalDate birthDate;

}
