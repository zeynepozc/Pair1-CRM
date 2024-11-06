//package com.etiya.productservice.consumer;
//
//import com.etiya.event.ProductsCalledEvent;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.context.annotation.Bean;
//import org.springframework.stereotype.Component;
//
//import java.util.function.Consumer;
//
//@Component
//@Slf4j
//public class ProductConsumer {
//
//    @Bean
//    public Consumer<ProductsCalledEvent> productsCalledEvent()
//    {
//        return event -> {
//            log.info("Customerservice'ten openfeign ve kafka kullanıldı, stream'den alındı. CustomerId:" + event.getId());
//        };
//    }
//}