package com.etiya.customerservice.service.concrete;

import com.etiya.customerservice.entity.City;
import com.etiya.customerservice.mapper.CityMapper;
import com.etiya.customerservice.repository.CityRepository;
import com.etiya.customerservice.service.abstracts.CityService;
import com.etiya.customerservice.service.dto.request.city.CreateCityRequestDto;
import com.etiya.customerservice.service.dto.request.city.UpdateCityRequestDto;
import com.etiya.customerservice.service.dto.response.city.CreateCityResponseDto;
import com.etiya.customerservice.service.dto.response.city.GetByIdCityResponseDto;
import com.etiya.customerservice.service.dto.response.city.ListCityResponseDto;
import com.etiya.customerservice.service.dto.response.city.UpdateCityResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CityServiceImpl implements CityService
{
    private final CityRepository cityRepository;
    private final CityMapper cityMapper;


    @Override
    public List<ListCityResponseDto> getAll() {
        List<City> cityList = cityRepository.findAll();
        return cityMapper.listCityResponseDtoListFromCityList(cityList);
    }

    @Override
    public GetByIdCityResponseDto getById(Long id) {
        Optional<City> city = cityRepository.findById(id);
        return cityMapper.getByIdCityResponseDtoFromCity(city.get());
    }

    @Override
    public CreateCityResponseDto add(CreateCityRequestDto createCityRequestDto) {
        // todo check if the given country exists
        City city = cityMapper.cityFromCreateCityRequestDto(createCityRequestDto);
        return cityMapper.createCityResponseDtoFromCity(cityRepository.save(city));
    }

    @Override
    public UpdateCityResponseDto update(UpdateCityRequestDto updateCityRequestDto) {
        // todo check if the given country exists
        City city = cityMapper.cityFromUpdateCityRequestDto(updateCityRequestDto);
        city = cityRepository.save(city);
        return cityMapper.updateCityResponseDtoFromCity(city);
    }

    @Override
    public void delete(Long id) {
        cityRepository.deleteById(id);
    }
}
