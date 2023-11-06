package com.hbdev.carvalueestimatorbackend.mapper;

import com.hbdev.carvalueestimatorbackend.database.entity.CarEntity;
import com.hbdev.carvalueestimatorbackend.model.requestDTO.CarRequestDTO;
import com.hbdev.carvalueestimatorbackend.model.responseDTO.CarResponseDTO;
import com.hbdev.carvalueestimatorbackend.util.IBaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.web.bind.annotation.Mapping;

@Mapper
public interface CarMapper extends IBaseMapper<CarEntity, CarResponseDTO, CarRequestDTO> {
    CarMapper INSTANCE = Mappers.getMapper(CarMapper.class);

}
