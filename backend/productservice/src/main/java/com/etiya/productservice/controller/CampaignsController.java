package com.etiya.productservice.controller;

import com.etiya.productservice.service.abstracts.CampaignService;
import com.etiya.productservice.service.dto.request.campaign.*;
import com.etiya.productservice.service.dto.responses.campaign.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/campaigns")
@RequiredArgsConstructor
public class CampaignsController {

    private final CampaignService campaignService;

    @GetMapping
    public List<ListCampaignResponseDto> getAll() {
        return campaignService.getAll();
    }

    @PostMapping
    public ResponseEntity<CreateCampaignResponseDto> add(@RequestBody @Validated CreateCampaignRequestDto createCampaignRequestDto) {
        CreateCampaignResponseDto createCampaignResponseDto = campaignService.add(createCampaignRequestDto);

        if (createCampaignResponseDto != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(createCampaignResponseDto);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<UpdateCampaignResponseDto> update(@PathVariable Long id, @RequestBody @Validated UpdateCampaignRequestDto updateCampaignRequestDto) {
        updateCampaignRequestDto.setId(id);
        UpdateCampaignResponseDto updateCampaignResponseDto = campaignService.update(updateCampaignRequestDto);
        return ResponseEntity.ok(updateCampaignResponseDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        GetByIdCampaignResponseDto campaign = campaignService.getById(id);

        if (campaign != null) {
            campaignService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetByIdCampaignResponseDto> getById(@PathVariable Long id) {
        GetByIdCampaignResponseDto campaign = campaignService.getById(id);

        if (campaign != null) {
            return ResponseEntity.ok(campaign);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}

