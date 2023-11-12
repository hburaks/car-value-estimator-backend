package com.hbdev.carvalueestimatorbackend.controller;

import com.hbdev.carvalueestimatorbackend.model.requestDTO.TagRequestDTO;
import com.hbdev.carvalueestimatorbackend.model.responseDTO.TagResponseDTO;
import com.hbdev.carvalueestimatorbackend.service.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("tags")
@RequiredArgsConstructor
public class TagController {
    private final TagService tagService;

    @GetMapping()
    public ResponseEntity<List<TagResponseDTO>> getTags() {
        return new ResponseEntity<>(tagService.getAllTags(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> removeTag(@PathVariable Long id) {
        try {
            tagService.removeTag(id);
            return new ResponseEntity<>("Tag removed successfully", HttpStatus.OK);
        } catch (DataAccessException e) {
            return new ResponseEntity<>("Error removing the tag: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping()
    public ResponseEntity<TagResponseDTO> addTag(@RequestBody TagRequestDTO tagRequestDTO) {
        try {
            TagResponseDTO tagResponseDTO = tagService.addNewTag(tagRequestDTO);
            return new ResponseEntity<>(tagResponseDTO, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping("/add-model-to-tag")
    public ResponseEntity<TagResponseDTO> addModelToExistingTag(@RequestBody TagRequestDTO tagRequestDTO){
        try {
            TagResponseDTO tagResponseDTO = tagService.addModelToExistingTag(tagRequestDTO);
            return new ResponseEntity<>(tagResponseDTO, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/remove-model-from-existing-tag")
    public ResponseEntity<TagResponseDTO> removeModelFromExistingTag(TagRequestDTO tagRequestDTO){
        try {
            TagResponseDTO tagResponseDTO = tagService.removeModelFromExistingTag(tagRequestDTO);
            return new ResponseEntity<>(tagResponseDTO, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

