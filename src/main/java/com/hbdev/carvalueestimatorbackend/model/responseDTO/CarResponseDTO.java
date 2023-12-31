package com.hbdev.carvalueestimatorbackend.model.responseDTO;

import com.hbdev.carvalueestimatorbackend.enums.FuelTypeEnum;
import com.hbdev.carvalueestimatorbackend.enums.TransmissionTypeEnum;
import com.hbdev.carvalueestimatorbackend.util.BaseResponseDTO;
import lombok.Data;

@Data
public class CarResponseDTO extends BaseResponseDTO {
    private String distance;
    private FuelTypeEnum fuelType;
    private Long estimatedValue;
    private Long expectedValue;
    private String make;
    private String model;
    private TransmissionTypeEnum transmission;
    private Integer year;
}
