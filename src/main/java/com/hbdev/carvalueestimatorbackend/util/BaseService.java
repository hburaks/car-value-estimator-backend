package com.hbdev.carvalueestimatorbackend.util;

import com.hbdev.carvalueestimatorbackend.util.dbutil.BaseEntity;
import com.hbdev.carvalueestimatorbackend.util.dbutil.IBaseRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;
import java.util.stream.Collectors;

public abstract class BaseService<
        Entity extends BaseEntity,
        ResponseDTO extends BaseResponseDTO,
        RequestDTO extends BaseRequestDTO,
        Repository extends IBaseRepository<Entity>,
        Mapper extends IBaseMapper<Entity, ResponseDTO, RequestDTO>> {

    protected abstract Mapper getBaseMapper();


    protected abstract Repository getBaseRepository();

    public PageResponseDTO<ResponseDTO> getAll(BaseFilterRequestDTO baseFilterRequestDTO) {
        Pageable pageable;
        if (baseFilterRequestDTO.getSortDTO() != null) {
            if (baseFilterRequestDTO.getSortDTO().getDirectionEnum() == Sort.Direction.ASC) {
                pageable = PageRequest.of(baseFilterRequestDTO.getPageNumber(),baseFilterRequestDTO.getPageSize(),
                        Sort.by(baseFilterRequestDTO.getSortDTO().getColumnName()).ascending());
            } else {
                pageable = PageRequest.of(baseFilterRequestDTO.getPageNumber(),baseFilterRequestDTO.getPageSize(),
                        Sort.by(baseFilterRequestDTO.getSortDTO().getColumnName()).descending());
            }
        } else {
            pageable = PageRequest.of(baseFilterRequestDTO.getPageNumber(),baseFilterRequestDTO.getPageSize(),
                    Sort.by("id").ascending());
        }
        Page<Entity> entityPage = getBaseRepository().findAll(pageable);
        PageResponseDTO<ResponseDTO> responseDTO = new PageResponseDTO<>();
        responseDTO.setTotalElements(entityPage.getTotalElements());
        responseDTO.setTotalPages(entityPage.getTotalPages());
        responseDTO.setSize(entityPage.getSize());

        responseDTO.setSort(entityPage.getSort());
        responseDTO.setNumber(entityPage.getNumber());
        responseDTO.setHasContent(entityPage.hasContent());
        responseDTO.setContent(getBaseMapper().entityListToResponseDtoList(entityPage.getContent()));
        entityPage.get().map(entity -> getBaseMapper().entityToResponseDto(entity)).collect(Collectors.toList());
        return responseDTO;
    }
    //TODO null response problem
    @Transactional
    public ResponseDTO save(RequestDTO requestDTO) {
        Entity entity = getBaseMapper().requestDtoToEntity(requestDTO);
        Entity entity2 = getBaseRepository().save(entity);
        return getBaseMapper().entityToResponseDto(entity2);
    }

    @Transactional
    public ResponseDTO update(UUID uuid, RequestDTO requestDTO) {
        Entity entity = getBaseRepository().findByUuid(uuid).orElse(null);
        if (entity == null) {
            return null;
        }
        return getBaseMapper().entityToResponseDto(getBaseRepository().save(getBaseMapper().updateEntityFromRequestDTO(requestDTO, entity)));
    }
    @Transactional
    public Boolean deleteByUuid(UUID uuid) {
        Entity entity = getBaseRepository().findByUuid(uuid).orElse(null);
        if (entity != null) {
            getBaseRepository().delete(entity);
            return true;
        }
        return false;
    }

    public ResponseDTO getByUuid(UUID uuid) {
        Entity entity = getBaseRepository().findByUuid(uuid).orElse(null);
        if (entity != null) {
            return getBaseMapper().entityToResponseDto(entity);
        } else {
            return null;
        }
    }

    public Entity getEntityByUuid(UUID uuid) {
        return getBaseRepository().findByUuid(uuid).orElse(null);
    }
}