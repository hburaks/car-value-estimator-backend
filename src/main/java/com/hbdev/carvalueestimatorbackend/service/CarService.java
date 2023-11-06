package com.hbdev.carvalueestimatorbackend.service;

import com.hbdev.carvalueestimatorbackend.database.entity.CarEntity;
import com.hbdev.carvalueestimatorbackend.database.repository.CarRepository;
import com.hbdev.carvalueestimatorbackend.mapper.CarMapper;
import com.hbdev.carvalueestimatorbackend.model.requestDTO.CarRequestDTO;
import com.hbdev.carvalueestimatorbackend.model.responseDTO.CarResponseDTO;
import com.hbdev.carvalueestimatorbackend.util.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CarService extends BaseService<
        CarEntity, CarResponseDTO, CarRequestDTO, CarRepository, CarMapper> {

    private final CarRepository carRepository;

    @Override
    protected CarMapper getBaseMapper() {
        return CarMapper.INSTANCE;
    }

    @Override
    protected CarRepository getBaseRepository() {
        return this.carRepository;
    }





}
