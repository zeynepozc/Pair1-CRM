package com.etiya.customerservice.mapper;

import com.etiya.customerservice.entity.Country;
import com.etiya.customerservice.service.dto.request.country.CreateCountryRequestDto;
import com.etiya.customerservice.service.dto.request.country.UpdateCountryRequestDto;
import com.etiya.customerservice.service.dto.response.country.CreateCountryResponseDto;
import com.etiya.customerservice.service.dto.response.country.GetByIdCountryResponseDto;
import com.etiya.customerservice.service.dto.response.country.ListCountryResponseDto;
import com.etiya.customerservice.service.dto.response.country.UpdateCountryResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public abstract class CountryMapper {


    public abstract Country countryFromCreateCountryRequestDto(CreateCountryRequestDto dto);

    public abstract Country countryFromUpdateCountryRequestDto(UpdateCountryRequestDto dto);

    public abstract CreateCountryResponseDto createCountryResponseDtoFromCountry(Country country);

    public abstract GetByIdCountryResponseDto getByIdCountryResponseDtoFromCountry(Country country);

    public abstract UpdateCountryResponseDto updateCountryResponseDtoFromCountry(Country country);

    public abstract List<ListCountryResponseDto> listCountryResponseDtoListFromCountryList(List<Country> countryList);

}
