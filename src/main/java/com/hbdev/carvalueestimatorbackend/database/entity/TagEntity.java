package com.hbdev.carvalueestimatorbackend.database.entity;

import com.hbdev.carvalueestimatorbackend.enums.FuelTypeEnum;
import com.hbdev.carvalueestimatorbackend.enums.TransmissionTypeEnum;
import com.hbdev.carvalueestimatorbackend.util.dbutil.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Entity
@Table(name = "tags")
@Data
public class TagEntity extends BaseEntity {
    private String make;
    private List<String> model;
}
