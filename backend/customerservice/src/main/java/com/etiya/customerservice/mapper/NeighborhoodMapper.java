package com.etiya.customerservice.mapper;

import com.etiya.customerservice.entity.Neighborhood;
import com.etiya.customerservice.service.dto.request.neighborhood.CreateNeighborhoodRequestDto;
import com.etiya.customerservice.service.dto.request.neighborhood.UpdateNeighborhoodRequestDto;
import com.etiya.customerservice.service.dto.response.neighborhood.CreateNeighborhoodResponseDto;
import com.etiya.customerservice.service.dto.response.neighborhood.GetByIdNeighborhoodResponseDto;
import com.etiya.customerservice.service.dto.response.neighborhood.ListNeighborhoodResponseDto;
import com.etiya.customerservice.service.dto.response.neighborhood.UpdateNeighborhoodResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public abstract class NeighborhoodMapper {

    @Mapping(source = "districtId", target = "district.id")
    public abstract Neighborhood neighborhoodFromCreateNeighborhoodRequestDto(CreateNeighborhoodRequestDto dto);

    @Mapping(source = "districtId", target = "district.id")
    public abstract Neighborhood neighborhoodFromUpdateNeighborhoodRequestDto(UpdateNeighborhoodRequestDto dto);

    @Mapping(source = "district.id", target = "districtId")
    public abstract CreateNeighborhoodResponseDto createNeighborhoodResponseDtoFromNeighborhood(Neighborhood neighborhood);

    @Mapping(source = "district.id", target = "districtId")
    public abstract GetByIdNeighborhoodResponseDto getByIdNeighborhoodResponseDtoFromNeighborhood(Neighborhood neighborhood);

    @Mapping(source = "district.id", target = "districtId")
    public abstract UpdateNeighborhoodResponseDto updateNeighborhoodResponseDtoFromNeighborhood(Neighborhood neighborhood);

    @Mapping(source = "district.id", target = "districtId")
    public abstract List<ListNeighborhoodResponseDto> listNeighborhoodResponseDtoListFromNeighborhoodList(List<Neighborhood> neighborhoodList);

    @Mapping(source = "district.id", target = "districtId")
    public abstract ListNeighborhoodResponseDto neighborhoodToNeighborhoodResponseDto(Neighborhood neighborhood);
}
