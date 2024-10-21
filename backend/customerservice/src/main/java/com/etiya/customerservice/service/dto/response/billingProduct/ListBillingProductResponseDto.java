package com.etiya.customerservice.service.dto.response.billingProduct;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ListBillingProductResponseDto {
    private Long id;
    private Long customerAccountId;
    private List<Long> productIdList;
}
