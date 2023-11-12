package com.hbdev.carvalueestimatorbackend.mapper;

import com.hbdev.carvalueestimatorbackend.database.entity.TagEntity;
import com.hbdev.carvalueestimatorbackend.model.requestDTO.TagRequestDTO;
import com.hbdev.carvalueestimatorbackend.model.responseDTO.TagResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ITagMapper {

    ITagMapper INSTANCE = Mappers.getMapper(ITagMapper.class);

    TagResponseDTO entityToResponse(TagEntity tag);

    TagEntity requestToEntity(TagRequestDTO tag);
}
