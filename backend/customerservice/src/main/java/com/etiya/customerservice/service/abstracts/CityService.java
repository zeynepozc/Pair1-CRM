package com.etiya.customerservice.service.abstracts;

import com.etiya.customerservice.service.dto.request.city.CreateCityRequestDto;
import com.etiya.customerservice.service.dto.request.city.UpdateCityRequestDto;
import com.etiya.customerservice.service.dto.response.city.CreateCityResponseDto;
import com.etiya.customerservice.service.dto.response.city.GetByIdCityResponseDto;
import com.etiya.customerservice.service.dto.response.city.ListCityResponseDto;
import com.etiya.customerservice.service.dto.response.city.UpdateCityResponseDto;

import java.util.List;

public interface CityService {
    List<ListCityResponseDto> getAll();
    GetByIdCityResponseDto getById(Long id);
    CreateCityResponseDto add(CreateCityRequestDto dto);
    UpdateCityResponseDto update(UpdateCityRequestDto dto);
    void delete(Long id);
}
