package com.hbdev.carvalueestimatorbackend.service;

import com.hbdev.carvalueestimatorbackend.database.entity.TagEntity;
import com.hbdev.carvalueestimatorbackend.database.repository.TagRepository;
import com.hbdev.carvalueestimatorbackend.mapper.ITagMapper;
import com.hbdev.carvalueestimatorbackend.model.requestDTO.TagRequestDTO;
import com.hbdev.carvalueestimatorbackend.model.responseDTO.TagResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TagService {

    private final TagRepository tagRepository;

    protected TagRepository getTagRepository() {
        return this.tagRepository;
    }


    public List<TagResponseDTO> getAllTags() {
        try {
            List<TagEntity> tagEntities = getTagRepository().findAll();
            return tagEntities.stream()
                    .map(ITagMapper.INSTANCE::entityToResponse)
                    .collect(Collectors.toList());
        } catch (DataAccessException e) {
            throw new RuntimeException("Error accessing the database", e);
        }
    }

    public TagResponseDTO addNewTag(TagRequestDTO tagRequestDTO) {
        TagEntity tagEntity = ITagMapper.INSTANCE.requestToEntity(tagRequestDTO);
        try {
            return ITagMapper.INSTANCE.entityToResponse(tagRepository.save(tagEntity));
        } catch (DataAccessException e) {
            throw new RuntimeException("Error saving tagEntity to the database", e);
        }
    }

    public void removeTag(Long id) {
        tagRepository.deleteById(id);
    }

    public TagResponseDTO addModelToExistingTag(TagRequestDTO tagRequestDTO) {
        TagEntity tagEntity = tagRepository.findById(tagRequestDTO.getId()).orElseThrow();
        tagEntity.getModel().addAll(tagRequestDTO.getModel());
        return ITagMapper.INSTANCE.entityToResponse(tagRepository.save(tagEntity));
    }

    public TagResponseDTO removeModelFromExistingTag(TagRequestDTO tagRequestDTO) {
        TagEntity tagEntity = tagRepository.findById(tagRequestDTO.getId()).orElseThrow();
        tagEntity.getModel().removeAll(tagRequestDTO.getModel());
        return ITagMapper.INSTANCE.entityToResponse(tagRepository.save(tagEntity));
    }
}
