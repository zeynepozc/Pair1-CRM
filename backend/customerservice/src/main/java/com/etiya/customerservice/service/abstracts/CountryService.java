package com.etiya.customerservice.service.abstracts;

import com.etiya.customerservice.service.dto.request.country.CreateCountryRequestDto;
import com.etiya.customerservice.service.dto.request.country.UpdateCountryRequestDto;
import com.etiya.customerservice.service.dto.response.country.CreateCountryResponseDto;
import com.etiya.customerservice.service.dto.response.country.GetByIdCountryResponseDto;
import com.etiya.customerservice.service.dto.response.country.ListCountryResponseDto;
import com.etiya.customerservice.service.dto.response.country.UpdateCountryResponseDto;

import java.util.List;

public interface CountryService {
    List<ListCountryResponseDto> getAll();
    GetByIdCountryResponseDto getById(Short id);

    CreateCountryResponseDto add(CreateCountryRequestDto countryRequestDto);

    UpdateCountryResponseDto update(UpdateCountryRequestDto updateCountryRequestDto);

    void delete(Short id);
}
