package com.etiya.customerservice.service.dto.request.billingAccount;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateBillingAccountRequestDto {
    @NotNull
    private Long customerAccountId;
    
    private LocalDateTime billingDate;
}
