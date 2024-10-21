package com.etiya.orderservice.client;

import com.etiya.orderservice.entity.IndividualCustomer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name="customerservice")
public interface CustomerServiceClient {

    @PostMapping("/api/individualcustomers/search")
    IndividualCustomer findById(Long id);
}
