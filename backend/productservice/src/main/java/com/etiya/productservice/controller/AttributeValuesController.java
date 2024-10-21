package com.etiya.productservice.controller;

import com.etiya.productservice.service.abstracts.AttributeValueService;
import com.etiya.productservice.service.dto.request.attributeValue.CreateAttributeValueRequestDto;
import com.etiya.productservice.service.dto.request.attributeValue.UpdateAttributeValueRequestDto;
import com.etiya.productservice.service.dto.responses.attributeValue.CreateAttributeValueResponseDto;
import com.etiya.productservice.service.dto.responses.attributeValue.GetByIdAttributeValueResponseDto;
import com.etiya.productservice.service.dto.responses.attributeValue.ListAttributeValueResponseDto;
import com.etiya.productservice.service.dto.responses.attributeValue.UpdateAttributeValueResponseDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/api/attributeValues")
@RequiredArgsConstructor
public class AttributeValuesController {
    private final AttributeValueService attributeValueService;

    @GetMapping
    public List<ListAttributeValueResponseDto> getAll(){
        return attributeValueService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetByIdAttributeValueResponseDto> getById(@PathVariable Long id){
        GetByIdAttributeValueResponseDto attributeValue = attributeValueService.getById(id);

        if (attributeValue != null) {
            return ResponseEntity.ok(attributeValue);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping
    public ResponseEntity<CreateAttributeValueResponseDto> add(@RequestBody @Valid CreateAttributeValueRequestDto createAttributeValueRequestDto){
        CreateAttributeValueResponseDto createAttributeValueResponseDto = attributeValueService.add(createAttributeValueRequestDto);

        if (createAttributeValueResponseDto != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(createAttributeValueResponseDto);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        GetByIdAttributeValueResponseDto attributeValue = attributeValueService.getById(id);

        if (attributeValue != null) {
            attributeValueService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<UpdateAttributeValueResponseDto> update(@PathVariable Long id, @RequestBody @Valid UpdateAttributeValueRequestDto updateAttributeValueRequestDto){
        UpdateAttributeValueResponseDto attributeValue = attributeValueService.update(id, updateAttributeValueRequestDto);

        if (attributeValue != null) {
            return ResponseEntity.ok(attributeValue);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
