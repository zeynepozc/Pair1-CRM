package com.etiya.customerservice.service.concrete;

import com.etiya.customerservice.service.dto.request.individualCustomer.CreateIndividualCustomerRequestDto;
import com.etiya.customerservice.service.dto.request.individualCustomer.SearchIndividualCustomerRequestDto;
import com.etiya.customerservice.service.dto.request.individualCustomer.UpdateIndividualCustomerRequestDto;
import com.etiya.customerservice.service.dto.response.individualCustomer.CreateIndividualCustomerResponseDto;
import com.etiya.customerservice.service.dto.response.individualCustomer.ListIndividualCustomerResponseDto;
import com.etiya.customerservice.service.dto.response.individualCustomer.SearchIndividualCustomerResponseDto;
import com.etiya.customerservice.service.dto.response.individualCustomer.UpdateIndividualCustomerResponseDto;
import io.github.cagataysero.exception.type.BusinessException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.dao.EmptyResultDataAccessException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


class IndividualCustomerServiceImplTest {
    @Mock
    private IndividualCustomerServiceImpl individualCustomerService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void getAll_ShouldReturnCustomerList() {
        List<ListIndividualCustomerResponseDto> responseDtos = List.of(new ListIndividualCustomerResponseDto());

        when(individualCustomerService.getAll()).thenReturn(responseDtos);

        List<ListIndividualCustomerResponseDto> result = individualCustomerService.getAll();

        assertEquals(1, result.size());
        verify(individualCustomerService).getAll();
    }

    @Test
    public void getById_WhenCustomerNotFound_ShouldThrowException() {
        Long id = 1L;
        when(individualCustomerService.getById(id)).thenThrow(NoSuchElementException.class);

        assertThrows(NoSuchElementException.class, () -> individualCustomerService.getById(id));
    }

    @Test
    public void add_ShouldCreateNewCustomer() {
        CreateIndividualCustomerRequestDto requestDto = new CreateIndividualCustomerRequestDto(
                "12345678901", "John", "Doe", "M.", "Father", "Mother", "Male", LocalDate.of(1990, 1, 1));
        CreateIndividualCustomerResponseDto responseDto = new CreateIndividualCustomerResponseDto();

        when(individualCustomerService.add(requestDto)).thenReturn(responseDto);

        CreateIndividualCustomerResponseDto result = individualCustomerService.add(requestDto);

        assertNotNull(result);
        verify(individualCustomerService).add(requestDto);
    }

    @Test
    public void add_WhenInvalidNatId_ShouldThrowBusinessException() {
        CreateIndividualCustomerRequestDto requestDto = new CreateIndividualCustomerRequestDto(
                "123", "John", "Doe", "M.", "Father", "Mother", "Male", LocalDate.of(1990, 1, 1));

        when(individualCustomerService.add(requestDto)).thenThrow(BusinessException.class);

        assertThrows(BusinessException.class, () -> individualCustomerService.add(requestDto));
    }

    @Test
    public void update_ShouldUpdateCustomer() {
        UpdateIndividualCustomerRequestDto requestDto = new UpdateIndividualCustomerRequestDto(
                1L, "John", "Doe", "M.", "Father", "Mother", "Male", LocalDate.of(1990, 1, 1));
        UpdateIndividualCustomerResponseDto responseDto = new UpdateIndividualCustomerResponseDto();

        when(individualCustomerService.update(requestDto)).thenReturn(responseDto);

        UpdateIndividualCustomerResponseDto result = individualCustomerService.update(requestDto);

        assertNotNull(result);
        verify(individualCustomerService).update(requestDto);
    }

    @Test
    public void delete_WhenIdNotFound_ShouldThrowException() {
        Long id = 1L;
        doThrow(new EmptyResultDataAccessException(1)).when(individualCustomerService).delete(id);

        assertThrows(EmptyResultDataAccessException.class, () -> individualCustomerService.delete(id));
    }

    @Test
    public void searchByFilters_ShouldReturnMatchingCustomers() {
        SearchIndividualCustomerRequestDto requestDto = new SearchIndividualCustomerRequestDto(
                "12345678901", 1L, "John", "Doe", "555-1234", "john@example.com", true, LocalDate.now());
        List<SearchIndividualCustomerResponseDto> responseDtos = List.of(new SearchIndividualCustomerResponseDto());

        when(individualCustomerService.searchByFilters(requestDto)).thenReturn(responseDtos);

        List<SearchIndividualCustomerResponseDto> result = individualCustomerService.searchByFilters(requestDto);

        assertEquals(1, result.size());
        verify(individualCustomerService).searchByFilters(requestDto);
    }
}
