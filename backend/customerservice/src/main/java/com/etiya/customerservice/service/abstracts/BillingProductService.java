package com.etiya.customerservice.service.abstracts;

import com.etiya.customerservice.entity.BillingProduct;
import com.etiya.customerservice.entity.Product;
import com.etiya.customerservice.service.dto.request.billingProduct.CreateBillingProductRequestDto;
import com.etiya.customerservice.service.dto.response.billingProduct.CreateBillingProductResponseDto;
import com.etiya.customerservice.service.dto.response.billingProduct.GetByIdBillingProductResponseDto;
import com.etiya.customerservice.service.dto.response.billingProduct.ListBillingProductResponseDto;

import java.util.List;
import java.util.Optional;

public interface BillingProductService {
    List<ListBillingProductResponseDto> getAll();
    GetByIdBillingProductResponseDto getById(Long id);

    List<Product> getProducts(List<Long> idList);

    List<Product> getProductsByBillingAccountId(Long id);

    List<BillingProduct> findBillingProductsByBillingAccountId(Long id);
    CreateBillingProductResponseDto add(CreateBillingProductRequestDto dto);
    void delete(Long id);
}
