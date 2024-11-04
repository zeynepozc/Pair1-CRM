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
public class ListCustomerAccountWithProductsResponseDto {
    private Long customerId;
    private String accountStatus;
    private String accountNumber;
    private String accountName;
    private String accountType;
    private String accountDescription;
    private List<Product> productList;
}
