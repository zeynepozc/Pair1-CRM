package com.etiya.orderservice.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product
{
    private Long id;
    private String name;
    private BigDecimal unitPrice;
    private int stockQuantity;
    private String categoryName;
}