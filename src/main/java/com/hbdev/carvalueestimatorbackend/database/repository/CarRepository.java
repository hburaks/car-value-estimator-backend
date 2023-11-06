package com.hbdev.carvalueestimatorbackend.database.repository;

import com.hbdev.carvalueestimatorbackend.database.entity.CarEntity;
import com.hbdev.carvalueestimatorbackend.util.dbutil.IBaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends IBaseRepository<CarEntity> {
}
