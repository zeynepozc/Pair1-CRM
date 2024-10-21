package com.etiya.customerservice.mapper;

import com.etiya.customerservice.entity.City;
import com.etiya.customerservice.service.dto.request.city.CreateCityRequestDto;
import com.etiya.customerservice.service.dto.request.city.UpdateCityRequestDto;
import com.etiya.customerservice.service.dto.response.city.CreateCityResponseDto;
import com.etiya.customerservice.service.dto.response.city.GetByIdCityResponseDto;
import com.etiya.customerservice.service.dto.response.city.ListCityResponseDto;
import com.etiya.customerservice.service.dto.response.city.UpdateCityResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public abstract class CityMapper {

    @Mapping(source="city", target = "name")
    @Mapping(source="countryId", target = "country.id")
    public abstract City cityFromCreateCityRequestDto(CreateCityRequestDto dto);

    @Mapping(source="city", target = "name")
    @Mapping(source="countryId", target = "country.id")
    public abstract City cityFromUpdateCityRequestDto(UpdateCityRequestDto dto);

    @Mapping(source="name", target = "cityName")
    @Mapping(source="country.id", target = "countryId")
    public abstract CreateCityResponseDto createCityResponseDtoFromCity(City city);

    @Mapping(source="country.id", target = "countryId")
    public abstract GetByIdCityResponseDto getByIdCityResponseDtoFromCity(City city);

    @Mapping(source="country.id", target = "countryId")
    public abstract UpdateCityResponseDto updateCityResponseDtoFromCity(City city);

    @Mapping(source="country.id", target = "countryId")
    public abstract List<ListCityResponseDto> listCityResponseDtoListFromCityList(List<City> city);

    @Mapping(source="country.id", target = "countryId")
    public abstract ListCityResponseDto cityToListCityResponseDto(City city);

}
