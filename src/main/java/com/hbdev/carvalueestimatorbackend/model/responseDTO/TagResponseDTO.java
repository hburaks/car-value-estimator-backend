package com.hbdev.carvalueestimatorbackend.model.responseDTO;

import com.hbdev.carvalueestimatorbackend.util.BaseResponseDTO;
import lombok.Data;

import java.util.List;

@Data
public class TagResponseDTO extends BaseResponseDTO {
    private String make;
    private List<String> model;
}
