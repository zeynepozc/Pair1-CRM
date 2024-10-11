package com.etiya.customerservice.dto.individualcustomer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class IndCustCreateResponseDto {

    private String natID;
    private String firstName;
    private String lastName;
    private String middleName;
    private String fatherName;
    private String motherName;
    private String gender;
    private LocalDate birthDate;
}