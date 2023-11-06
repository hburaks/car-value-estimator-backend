package com.hbdev.carvalueestimatorbackend.model.requestDTO;

import com.hbdev.carvalueestimatorbackend.enums.FuelTypeEnum;
import com.hbdev.carvalueestimatorbackend.enums.TransmissionTypeEnum;
import com.hbdev.carvalueestimatorbackend.util.BaseRequestDTO;
import lombok.Data;

@Data
public class CarRequestDTO extends BaseRequestDTO {
    private String distance;
    private FuelTypeEnum fuelType;
    private Long expectedValue;
    private String make;
    private String model;
    private TransmissionTypeEnum transmission;
    private Integer year;
}
