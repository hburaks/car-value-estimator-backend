package com.hbdev.carvalueestimatorbackend.controller;

import com.hbdev.carvalueestimatorbackend.model.requestDTO.CarRequestDTO;
import com.hbdev.carvalueestimatorbackend.model.responseDTO.CarResponseDTO;
import com.hbdev.carvalueestimatorbackend.service.CarService;
import com.hbdev.carvalueestimatorbackend.util.BaseFilterRequestDTO;
import com.hbdev.carvalueestimatorbackend.util.PageResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("car")
@RequiredArgsConstructor
public class CarController {

    private final CarService carService;

    @GetMapping("tags")
    public ResponseEntity<String> test() {

        return new ResponseEntity<>("hi", HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> removeCar(@PathVariable Long id) {
        try {
            carService.removeCar(id);
            return new ResponseEntity<>("Car removed successfully", HttpStatus.OK);
        } catch (DataAccessException e) {
            return new ResponseEntity<>("Error removing the car: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/estimate-value")
    public ResponseEntity<CarResponseDTO> estimateCarValue(@RequestBody CarRequestDTO carRequestDTO) {
        try {
            CarResponseDTO estimatedValue = carService.estimateCarValue(carRequestDTO);
            return new ResponseEntity<>(estimatedValue, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<PageResponseDTO<CarResponseDTO>> getAllPageable(@RequestBody BaseFilterRequestDTO baseFilterRequestDTO) {
        try {
            PageResponseDTO<CarResponseDTO> responseDTO = carService.getAllPageable(baseFilterRequestDTO);
            return new ResponseEntity<>(responseDTO, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}

