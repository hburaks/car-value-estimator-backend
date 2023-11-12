package com.hbdev.carvalueestimatorbackend.database.repository;

import com.hbdev.carvalueestimatorbackend.database.entity.TagEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TagRepository extends JpaRepository<TagEntity, Long> {
}
