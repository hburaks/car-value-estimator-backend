package com.hbdev.carvalueestimatorbackend.controller;

import com.hbdev.carvalueestimatorbackend.database.entity.CarEntity;
import com.hbdev.carvalueestimatorbackend.database.repository.CarRepository;
import com.hbdev.carvalueestimatorbackend.mapper.CarMapper;
import com.hbdev.carvalueestimatorbackend.model.requestDTO.CarRequestDTO;
import com.hbdev.carvalueestimatorbackend.model.responseDTO.CarResponseDTO;
import com.hbdev.carvalueestimatorbackend.service.CarService;
import com.hbdev.carvalueestimatorbackend.util.BaseController;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("car")
@RequiredArgsConstructor
public class CarController extends BaseController<
        CarEntity, CarResponseDTO, CarRequestDTO, CarRepository, CarMapper, CarService> {

    private final CarService carService;

    @Override
    protected CarService getService() {
        return this.carService;
    }


}

