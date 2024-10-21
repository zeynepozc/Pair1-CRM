package com.etiya.customerservice.service.concrete;

import com.etiya.customerservice.entity.District;
import com.etiya.customerservice.mapper.DistrictMapper;
import com.etiya.customerservice.repository.DistrictRepository;
import com.etiya.customerservice.service.abstracts.DistrictService;
import com.etiya.customerservice.service.dto.request.district.CreateDistrictRequestDto;
import com.etiya.customerservice.service.dto.request.district.UpdateDistrictRequestDto;
import com.etiya.customerservice.service.dto.response.district.CreateDistrictResponseDto;
import com.etiya.customerservice.service.dto.response.district.GetByIdDistrictResponseDto;
import com.etiya.customerservice.service.dto.response.district.ListDistrictResponseDto;
import com.etiya.customerservice.service.dto.response.district.UpdateDistrictResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DistrictServiceImpl implements DistrictService {
    private final DistrictRepository districtRepository;
    private final DistrictMapper districtMapper;


    @Override
    public List<ListDistrictResponseDto> getAll() {
        List<District> districtList = districtRepository.findAll();
        return districtMapper.listDistrictResponseDtoListFromDistrictList(districtList);
    }

    @Override
    public GetByIdDistrictResponseDto getById(Long id) {
        Optional<District> district = districtRepository.findById(id);
        return districtMapper.getByIdDistrictResponseDtoFromDistrict(district.get());
    }

    @Override
    public CreateDistrictResponseDto add(CreateDistrictRequestDto createDistrictRequestDto) {
        // todo check if the given city exists
        District district = districtMapper.districtFromCreateDistrictRequestDto(createDistrictRequestDto);
        return districtMapper.createDistrictResponseDtoFromDistrict(districtRepository.save(district));
    }

    @Override
    public UpdateDistrictResponseDto update(UpdateDistrictRequestDto updateDistrictRequestDto) {
        // todo check if the given city exists
        District district = districtMapper.districtFromUpdateDistrictRequestDto(updateDistrictRequestDto);
        district = districtRepository.save(district);
        return districtMapper.updateDistrictResponseDtoFromDistrict(district);
    }

    @Override
    public void delete(Long id) {
        districtRepository.deleteById(id);
    }
}
