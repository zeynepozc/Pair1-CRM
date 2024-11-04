package com.etiya.customerservice.service.abstracts;

import com.etiya.customerservice.entity.Customer;
import com.etiya.customerservice.entity.IndividualCustomer;
import com.etiya.customerservice.service.dto.request.individualCustomer.CreateIndividualCustomerRequestDto;
import com.etiya.customerservice.service.dto.request.individualCustomer.IsCustomerExistsWithNatIDRequestDto;
import com.etiya.customerservice.service.dto.request.individualCustomer.SearchIndividualCustomerRequestDto;
import com.etiya.customerservice.service.dto.request.individualCustomer.UpdateIndividualCustomerRequestDto;
import com.etiya.customerservice.service.dto.response.individualCustomer.*;

import java.util.List;
import java.util.Optional;

public interface IndividualCustomerService {

    List<ListIndividualCustomerResponseDto> getAll();
    GetByIdIndividualCustomerResponseDto getById(Long id);

    Optional<IndividualCustomer> findById(Long id);
    CreateIndividualCustomerResponseDto add(CreateIndividualCustomerRequestDto dto);
    UpdateIndividualCustomerResponseDto update(UpdateIndividualCustomerRequestDto dto);
    void delete(Long id);
    void delete(IndividualCustomer individualCustomer);
    List<SearchIndividualCustomerResponseDto> searchByFilters(SearchIndividualCustomerRequestDto dto);
    IsCustomerExistsWithNatIDResponseDto isCustomerExistsWithNatID(IsCustomerExistsWithNatIDRequestDto dto);
}
