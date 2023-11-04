package com.hbdev.carvalueestimatorbackend.model.requestDTO;

import com.hbdev.carvalueestimatorbackend.util.BaseRequestDTO;
import lombok.Data;

@Data
public class CarRequestDTO extends BaseRequestDTO {
    private String distance;
    private String fuelType;
    private Long expectedValue;
    private String make;
    private String model;
    private String transmission;
    private Integer year;
}
