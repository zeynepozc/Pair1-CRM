package com.etiya.customerservice.service.concrete;

import com.etiya.customerservice.entity.Neighborhood;
import com.etiya.customerservice.mapper.NeighborhoodMapper;
import com.etiya.customerservice.repository.NeighborhoodRepository;
import com.etiya.customerservice.service.abstracts.NeighborhoodService;
import com.etiya.customerservice.service.dto.request.neighborhood.CreateNeighborhoodRequestDto;
import com.etiya.customerservice.service.dto.request.neighborhood.UpdateNeighborhoodRequestDto;
import com.etiya.customerservice.service.dto.response.neighborhood.CreateNeighborhoodResponseDto;
import com.etiya.customerservice.service.dto.response.neighborhood.GetByIdNeighborhoodResponseDto;
import com.etiya.customerservice.service.dto.response.neighborhood.ListNeighborhoodResponseDto;
import com.etiya.customerservice.service.dto.response.neighborhood.UpdateNeighborhoodResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class NeighborhoodServiceImpl implements NeighborhoodService {
    private final NeighborhoodRepository neighborhoodRepository;
    private final NeighborhoodMapper neighborhoodMapper;


    @Override
    public List<ListNeighborhoodResponseDto> getAll() {
        List<Neighborhood> neighborhoodList = neighborhoodRepository.findAll();
        return neighborhoodMapper.listNeighborhoodResponseDtoListFromNeighborhoodList(neighborhoodList);
    }

    @Override
    public GetByIdNeighborhoodResponseDto getById(Long id) {
        Optional<Neighborhood> neighborhood = neighborhoodRepository.findById(id);
        return neighborhoodMapper.getByIdNeighborhoodResponseDtoFromNeighborhood(neighborhood.get());
    }

    @Override
    public CreateNeighborhoodResponseDto add(CreateNeighborhoodRequestDto createNeighborhoodRequestDto) {
        // todo check if the given city exists
        Neighborhood neighborhood = neighborhoodMapper.neighborhoodFromCreateNeighborhoodRequestDto(createNeighborhoodRequestDto);
        return neighborhoodMapper.createNeighborhoodResponseDtoFromNeighborhood(neighborhoodRepository.save(neighborhood));
    }

    @Override
    public UpdateNeighborhoodResponseDto update(UpdateNeighborhoodRequestDto updateNeighborhoodRequestDto) {
        // todo check if the given city exists
        Neighborhood neighborhood = neighborhoodMapper.neighborhoodFromUpdateNeighborhoodRequestDto(updateNeighborhoodRequestDto);
        neighborhood = neighborhoodRepository.save(neighborhood);
        return neighborhoodMapper.updateNeighborhoodResponseDtoFromNeighborhood(neighborhood);
    }

    @Override
    public void delete(Long id) {
        neighborhoodRepository.deleteById(id);
    }
}
