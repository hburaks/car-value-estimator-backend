package com.hbdev.carvalueestimatorbackend.util;

import lombok.Data;

@Data
public class BaseFilterRequestDTO {
    private int pageNumber;
    private int pageSize;
    private SortDTO sortDTO;
    //private List<SearchCriteria> filters;
}
