package com.etiya.customerservice.service.concrete;

import com.etiya.customerservice.entity.City;
import com.etiya.customerservice.entity.ContactMedium;
import com.etiya.customerservice.service.abstracts.*;
import com.etiya.customerservice.service.dto.request.address.CreateAddressRequestDto;
import com.etiya.customerservice.service.dto.request.city.CreateCityRequestDto;
import com.etiya.customerservice.service.dto.request.contactAddress.CreateContactAddressRequestDto;
import com.etiya.customerservice.service.dto.request.contactMediumAddress.CreateContactMediumAddressRequestDto;
import com.etiya.customerservice.service.dto.request.district.CreateDistrictRequestDto;
import com.etiya.customerservice.service.dto.request.neighborhood.CreateNeighborhoodRequestDto;
import com.etiya.customerservice.service.dto.response.address.CreateAddressResponseDto;
import com.etiya.customerservice.service.dto.response.city.CreateCityResponseDto;
import com.etiya.customerservice.service.dto.response.contactAddress.CreateContactAddressResponseDto;
import com.etiya.customerservice.service.dto.response.contactMediumAddress.CreateContactMediumAddressResponseDto;
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
    private final ContactMediumAddressService contactMediumAddressService;

    @Override
    public CreateAddressResponseDto add(CreateAddressRequestDto dto){
        CreateAddressResponseDto createAddressResponseDto = new CreateAddressResponseDto();

        Optional<ContactMedium> contactMedium = contactMediumService.findByCustomerId(dto.getCustomerId());
        boolean isContactMediumPresent = contactMedium.isPresent();

        if (isContactMediumPresent){
            createAddressResponseDto.setCustomerId(dto.getCustomerId());
        }
        
        CreateCityRequestDto createCityRequestDto = new CreateCityRequestDto(dto.getCity(), (short) 1);
        CreateCityResponseDto createCityResponseDto = cityService.add(createCityRequestDto);
        createAddressResponseDto.setCity(createCityResponseDto.getName());

        CreateDistrictRequestDto createDistrictRequestDto = new CreateDistrictRequestDto(dto.getDistrict(),createCityResponseDto.getId());
        CreateDistrictResponseDto createDistrictResponseDto = districtService.add(createDistrictRequestDto);
        createAddressResponseDto.setDistrict(createDistrictResponseDto.getName());

        CreateNeighborhoodRequestDto createNeighborhoodRequestDto = new CreateNeighborhoodRequestDto(dto.getNeighborhood(),dto.getPostalCode(),dto.getHouseNo(),createDistrictResponseDto.getId());
        CreateNeighborhoodResponseDto createNeighborhoodResponseDto = neighborhoodService.add(createNeighborhoodRequestDto);
        createAddressResponseDto.setNeighborhood(createNeighborhoodResponseDto.getName());

        CreateContactAddressRequestDto createContactAddressRequestDto = new CreateContactAddressRequestDto(dto.getName(),dto.getDescription(),createNeighborhoodResponseDto.getId());
        CreateContactAddressResponseDto createContactAddressResponseDto = contactAddressService.add(createContactAddressRequestDto);
        createAddressResponseDto.setDescription(createContactAddressResponseDto.getAddressDesc());

        createAddressResponseDto.setId(createContactAddressResponseDto.getId());
        createAddressResponseDto.setName(dto.getName());
        createAddressResponseDto.setPostalCode(dto.getPostalCode());
        createAddressResponseDto.setHouseNo(dto.getHouseNo());
        createAddressResponseDto.setPrimaryAddress(dto.getPrimaryAddress());

        if (isContactMediumPresent) {
            CreateContactMediumAddressRequestDto contactMediumAddressRequestDto = new CreateContactMediumAddressRequestDto(
                    contactMedium.get().getId(),
                    createContactAddressResponseDto.getId(),
                    dto.getPrimaryAddress()
            );
            contactMediumAddressService.add(contactMediumAddressRequestDto);
        }

        return createAddressResponseDto;
    }

}
