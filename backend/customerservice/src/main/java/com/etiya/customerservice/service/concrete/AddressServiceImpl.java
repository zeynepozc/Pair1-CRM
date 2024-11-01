package com.etiya.customerservice.service.concrete;

import com.etiya.customerservice.entity.City;
import com.etiya.customerservice.entity.ContactMedium;
import com.etiya.customerservice.service.abstracts.*;
import com.etiya.customerservice.service.dto.request.address.CreateAddressRequestDto;
import com.etiya.customerservice.service.dto.request.city.CreateCityRequestDto;
import com.etiya.customerservice.service.dto.request.contactAddress.CreateContactAddressRequestDto;
import com.etiya.customerservice.service.dto.request.district.CreateDistrictRequestDto;
import com.etiya.customerservice.service.dto.request.neighborhood.CreateNeighborhoodRequestDto;
import com.etiya.customerservice.service.dto.response.address.CreateAddressResponseDto;
import com.etiya.customerservice.service.dto.response.city.CreateCityResponseDto;
import com.etiya.customerservice.service.dto.response.contactAddress.CreateContactAddressResponseDto;
import com.etiya.customerservice.service.dto.response.district.CreateDistrictResponseDto;
import com.etiya.customerservice.service.dto.response.neighborhood.CreateNeighborhoodResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {

    public final CityService cityService;
    public final DistrictService districtService;
    public final NeighborhoodService neighborhoodService;
    public final ContactAddressService contactAddressService;
    private final ContactMediumService contactMediumService;

    @Override
    public CreateContactAddressResponseDto add(CreateAddressRequestDto dto){
        Optional<ContactMedium> contactMedium = contactMediumService.findByCustomerId(dto.getCustomerId());

        CreateCityRequestDto createCityRequestDto = new CreateCityRequestDto(dto.getCity(), (short) 1);
        CreateCityResponseDto createCityResponseDto = cityService.add(createCityRequestDto);

        CreateDistrictRequestDto createDistrictRequestDto = new CreateDistrictRequestDto(dto.getDistrict(),createCityResponseDto.getId());
        CreateDistrictResponseDto createDistrictResponseDto = districtService.add(createDistrictRequestDto);

        CreateNeighborhoodRequestDto createNeighborhoodRequestDto = new CreateNeighborhoodRequestDto(dto.getNeighborhood(),dto.getPostalCode(),dto.getHouseNo(),createDistrictResponseDto.getId());
        CreateNeighborhoodResponseDto createNeighborhoodResponseDto = neighborhoodService.add(createNeighborhoodRequestDto);

        CreateContactAddressRequestDto createContactAddressRequestDto = new CreateContactAddressRequestDto(dto.getName(),dto.getDescription(),createNeighborhoodResponseDto.getId());

        return contactAddressService.add(createContactAddressRequestDto);
    }

}
