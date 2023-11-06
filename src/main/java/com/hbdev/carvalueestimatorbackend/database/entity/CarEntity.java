package com.hbdev.carvalueestimatorbackend.database.entity;

import com.hbdev.carvalueestimatorbackend.enums.FuelTypeEnum;
import com.hbdev.carvalueestimatorbackend.enums.TransmissionTypeEnum;
import com.hbdev.carvalueestimatorbackend.util.dbutil.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "cars")
@Data
public class CarEntity extends BaseEntity {

    private String distance;
    private FuelTypeEnum fuelType;
    private Long estimatedValue;
    private Long expectedValue;
    private String make;
    private String model;
    private TransmissionTypeEnum transmission;
    private Integer year;

}
