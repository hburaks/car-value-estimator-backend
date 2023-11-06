package com.hbdev.carvalueestimatorbackend.enums;

public enum TransmissionTypeEnum {
    AUTO("Auto"),
    MANUEL("Manuel");

    private final String label;

    private TransmissionTypeEnum(String label){
        this.label = label;
    }

}
