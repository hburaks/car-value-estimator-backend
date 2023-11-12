package com.hbdev.carvalueestimatorbackend.model.requestDTO;

import com.hbdev.carvalueestimatorbackend.util.BaseRequestDTO;
import com.hbdev.carvalueestimatorbackend.util.BaseResponseDTO;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class TagRequestDTO extends BaseRequestDTO {
    private String make;
    private List<String> model;
}
