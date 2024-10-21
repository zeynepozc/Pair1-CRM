package com.etiya.customerservice.service.dto.response.billingAccount;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateBillingAccountResponseDto {
    private Long id;
    private Long customerAccountId;
    private LocalDateTime billingDate;
}
