package com.etiya.orderservice.service;

import com.etiya.event.OrderCreatedEvent;
import com.etiya.orderservice.client.ProductServiceClient;
import com.etiya.orderservice.dto.ProductForOrderDto;
import com.etiya.orderservice.dto.CreateOrderRequest;
import com.etiya.orderservice.entity.Order;
import com.etiya.orderservice.entity.Product;
import com.etiya.orderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService{
    private final OrderRepository orderRepository;
    private final ProductServiceClient productServiceClient;
    private final KafkaTemplate<String, Object> kafkaTemplate;
    @Override
    public List<Order> getAll() {
        return orderRepository.findAll();
    }

    @Override
    public void add(CreateOrderRequest createOrderRequest) {
        // Customer bilgileri

        List<Product> response = productServiceClient.findAllByIds(
                createOrderRequest.getProducts().stream().map(ProductForOrderDto::getProductId).toList()
        );

        //TODO: Refactor as business rules.
        // OrderBusinessRules.AllProductsShouldExist()

        Order order = new Order();
        order.setOrderDate(LocalDate.now());
        order.setCustomerId(createOrderRequest.getCustomerId());
        order.setProducts(response);
        orderRepository.save(order);

        kafkaTemplate.send("orderTopic", new OrderCreatedEvent(order.getId()));
    }
}
