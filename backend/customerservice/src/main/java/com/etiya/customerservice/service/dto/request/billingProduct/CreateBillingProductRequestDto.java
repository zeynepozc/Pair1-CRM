package com.etiya.customerservice.service.dto.request.billingProduct;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateBillingProductRequestDto {
    @NotNull
    private Long billingAccountId;

    private List<Long> productIdList;
}
