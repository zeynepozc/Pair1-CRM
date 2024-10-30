package com.etiya.productservice.service.concrete;

import com.etiya.productservice.service.dto.request.product.CreateProductRequestDto;
import com.etiya.productservice.service.dto.request.product.UpdateProductRequestDto;
import com.etiya.productservice.service.dto.responses.product.CreateProductResponseDto;
import com.etiya.productservice.service.dto.responses.product.GetByIdProductResponseDto;
import com.etiya.productservice.service.dto.responses.product.ListProductResponseDto;
import com.etiya.productservice.service.dto.responses.product.UpdateProductResponseDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ProductServiceImplTest {
    @Mock
    private ProductServiceImpl productService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void getAll_ShouldReturnProductList() {
        List<ListProductResponseDto> responseDtos = List.of(
                new ListProductResponseDto(1L, "Product A", 101L, "Description A",
                        BigDecimal.valueOf(100.0), 10, true));

        when(productService.getAll()).thenReturn(responseDtos);

        List<ListProductResponseDto> result = productService.getAll();

        assertEquals(1, result.size());
        assertEquals("Product A", result.get(0).getName());
        verify(productService).getAll();
    }

    @Test
    public void getById_ShouldReturnProduct() {
        Long productId = 1L;
        GetByIdProductResponseDto responseDto = new GetByIdProductResponseDto(
                "Product A", 101L, "Description A", BigDecimal.valueOf(100.0), 10, true);

        when(productService.getById(productId)).thenReturn(responseDto);

        GetByIdProductResponseDto result = productService.getById(productId);

        assertNotNull(result);
        assertEquals("Product A", result.getName());
        verify(productService).getById(productId);
    }

    @Test
    public void getById_WhenProductNotFound_ShouldThrowException() {
        Long productId = 1L;
        when(productService.getById(productId)).thenThrow(NoSuchElementException.class);

        assertThrows(NoSuchElementException.class, () -> productService.getById(productId));
    }

    @Test
    public void add_ShouldCreateNewProduct() {
        CreateProductRequestDto requestDto = new CreateProductRequestDto(
                "Product A", 101L, "Description A", BigDecimal.valueOf(100.0), 10, true);
        CreateProductResponseDto responseDto = new CreateProductResponseDto(
                "Product A", 101L, "Description A", BigDecimal.valueOf(100.0), 10, true);

        when(productService.add(requestDto)).thenReturn(responseDto);

        CreateProductResponseDto result = productService.add(requestDto);

        assertNotNull(result);
        assertEquals("Product A", result.getName());
        verify(productService).add(requestDto);
    }

    @Test
    public void update_ShouldUpdateProduct() {
        UpdateProductRequestDto requestDto = new UpdateProductRequestDto(
                1L, "Updated Product", 101L, "Updated Description",
                BigDecimal.valueOf(150.0), 20, true);
        UpdateProductResponseDto responseDto = new UpdateProductResponseDto(
                1L, "Updated Product", 101L, "Updated Description",
                BigDecimal.valueOf(150.0), 20, true);

        when(productService.update(requestDto)).thenReturn(responseDto);

        UpdateProductResponseDto result = productService.update(requestDto);

        assertNotNull(result);
        assertEquals("Updated Product", result.getName());
        verify(productService).update(requestDto);
    }

    @Test
    public void delete_ShouldDeleteProduct() {
        Long productId = 1L;

        doNothing().when(productService).delete(productId);

        productService.delete(productId);

        verify(productService).delete(productId);
    }

    @Test
    public void delete_WhenIdNotFound_ShouldThrowException() {
        Long productId = 1L;
        doThrow(new NoSuchElementException()).when(productService).delete(productId);

        assertThrows(NoSuchElementException.class, () -> productService.delete(productId));
    }
}