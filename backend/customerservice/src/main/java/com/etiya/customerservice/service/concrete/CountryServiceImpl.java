package com.etiya.customerservice.service.concrete;

import com.etiya.customerservice.entity.Country;
import com.etiya.customerservice.mapper.CountryMapper;
import com.etiya.customerservice.repository.CountryRepository;
import com.etiya.customerservice.service.abstracts.CountryService;
import com.etiya.customerservice.service.dto.request.country.CreateCountryRequestDto;
import com.etiya.customerservice.service.dto.request.country.UpdateCountryRequestDto;
import com.etiya.customerservice.service.dto.response.country.CreateCountryResponseDto;
import com.etiya.customerservice.service.dto.response.country.GetByIdCountryResponseDto;
import com.etiya.customerservice.service.dto.response.country.ListCountryResponseDto;
import com.etiya.customerservice.service.dto.response.country.UpdateCountryResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CountryServiceImpl implements CountryService
{
    private final CountryRepository countryRepository;
    private final CountryMapper countryMapper;


    @Override
    public List<ListCountryResponseDto> getAll() {
        List<Country> countryList = countryRepository.findAll();
        return countryMapper.listCountryResponseDtoListFromCountryList(countryList);
    }

    @Override
    public GetByIdCountryResponseDto getById(Short id) {
        Optional<Country> country = countryRepository.findById(id);
        return countryMapper.getByIdCountryResponseDtoFromCountry(country.get());
    }

    @Override
    public CreateCountryResponseDto add(CreateCountryRequestDto countryRequestDto) {
        Country country = countryMapper.countryFromCreateCountryRequestDto(countryRequestDto);
        return countryMapper.createCountryResponseDtoFromCountry(countryRepository.save(country));
    }

    @Override
    public UpdateCountryResponseDto update(UpdateCountryRequestDto updateCountryRequestDto) {
        Country country = countryMapper.countryFromUpdateCountryRequestDto(updateCountryRequestDto);
        country = countryRepository.save(country);
        return countryMapper.updateCountryResponseDtoFromCountry(country);
    }

    @Override
    public void delete(Short id) {
        countryRepository.deleteById(id);
    }
}
