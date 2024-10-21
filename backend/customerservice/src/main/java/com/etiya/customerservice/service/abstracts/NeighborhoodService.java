package com.etiya.customerservice.service.abstracts;

import com.etiya.customerservice.service.dto.request.neighborhood.CreateNeighborhoodRequestDto;
import com.etiya.customerservice.service.dto.request.neighborhood.UpdateNeighborhoodRequestDto;
import com.etiya.customerservice.service.dto.response.neighborhood.CreateNeighborhoodResponseDto;
import com.etiya.customerservice.service.dto.response.neighborhood.GetByIdNeighborhoodResponseDto;
import com.etiya.customerservice.service.dto.response.neighborhood.ListNeighborhoodResponseDto;
import com.etiya.customerservice.service.dto.response.neighborhood.UpdateNeighborhoodResponseDto;

import java.util.List;

public interface NeighborhoodService {
    List<ListNeighborhoodResponseDto> getAll();
    GetByIdNeighborhoodResponseDto getById(Long id);
    CreateNeighborhoodResponseDto add(CreateNeighborhoodRequestDto dto);
    UpdateNeighborhoodResponseDto update(UpdateNeighborhoodRequestDto dto);
    void delete(Long id);
}
