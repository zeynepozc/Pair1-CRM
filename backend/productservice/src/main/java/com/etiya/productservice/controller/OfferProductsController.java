package com.etiya.productservice.controller;

import com.etiya.productservice.service.abstracts.OfferProductService;
import com.etiya.productservice.service.dto.request.offerProduct.*;
import com.etiya.productservice.service.dto.responses.offerProduct.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/offer-products")
@RequiredArgsConstructor
public class OfferProductsController {

    private final OfferProductService offerProductService;

    @GetMapping("/{id}")
    public ResponseEntity<GetByIdOfferProductResponseDto> getById(@PathVariable Long id) {
        GetByIdOfferProductResponseDto offerProduct = offerProductService.getById(id);
        return ResponseEntity.ok(offerProduct);
    }

    @GetMapping
    public ResponseEntity<List<GetByIdOfferProductResponseDto>> getAll() {
        List<GetByIdOfferProductResponseDto> offerProducts = offerProductService.getAll();
        return ResponseEntity.ok(offerProducts);
    }

    @PostMapping
    public ResponseEntity<Void> add(@RequestBody CreateOfferProductRequestDto createOfferProductRequestDto) {
        offerProductService.add(createOfferProductRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        offerProductService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}

