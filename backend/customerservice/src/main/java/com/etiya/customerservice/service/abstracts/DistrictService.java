package com.etiya.customerservice.service.abstracts;

import com.etiya.customerservice.service.dto.request.district.CreateDistrictRequestDto;
import com.etiya.customerservice.service.dto.request.district.UpdateDistrictRequestDto;
import com.etiya.customerservice.service.dto.response.district.CreateDistrictResponseDto;
import com.etiya.customerservice.service.dto.response.district.GetByIdDistrictResponseDto;
import com.etiya.customerservice.service.dto.response.district.ListDistrictResponseDto;
import com.etiya.customerservice.service.dto.response.district.UpdateDistrictResponseDto;

import java.util.List;

public interface DistrictService {
    List<ListDistrictResponseDto> getAll();
    GetByIdDistrictResponseDto getById(Long id);
    CreateDistrictResponseDto add(CreateDistrictRequestDto dto);
    UpdateDistrictResponseDto update(UpdateDistrictRequestDto dto);
    void delete(Long id);
}
