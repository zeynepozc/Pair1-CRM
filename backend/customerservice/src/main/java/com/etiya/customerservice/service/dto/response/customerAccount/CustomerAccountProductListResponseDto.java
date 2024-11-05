package com.etiya.customerservice.service.dto.response.customerAccount;

import com.etiya.customerservice.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerAccountProductListResponseDto {
    private List<Product> productList;
}
