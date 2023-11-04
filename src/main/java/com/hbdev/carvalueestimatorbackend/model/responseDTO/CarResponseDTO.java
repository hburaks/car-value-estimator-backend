package com.hbdev.carvalueestimatorbackend.model.responseDTO;

import com.hbdev.carvalueestimatorbackend.util.BaseResponseDTO;
import lombok.Data;

@Data
public class CarResponseDTO extends BaseResponseDTO {
    private String distance;
    private String fuelType;
    private Long estimatedValue;
    private Long expectedValue;
    private String make;
    private String model;
    private String transmission;
    private Integer year;
}
