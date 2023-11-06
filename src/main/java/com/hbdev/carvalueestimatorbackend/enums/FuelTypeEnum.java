package com.hbdev.carvalueestimatorbackend.enums;

public enum FuelTypeEnum {
    DIESEL("Diesel"),
    GASOLINE("Gasoline"),
    LPG("LPG");
    private final String label;
    private FuelTypeEnum(String label){
        this.label = label;
    }
}
