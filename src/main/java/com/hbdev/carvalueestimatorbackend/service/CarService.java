package com.hbdev.carvalueestimatorbackend.service;

import com.hbdev.carvalueestimatorbackend.database.entity.CarEntity;
import com.hbdev.carvalueestimatorbackend.database.repository.CarRepository;
import com.hbdev.carvalueestimatorbackend.mapper.CarMapper;
import com.hbdev.carvalueestimatorbackend.model.requestDTO.CarRequestDTO;
import com.hbdev.carvalueestimatorbackend.model.responseDTO.CarResponseDTO;
import com.hbdev.carvalueestimatorbackend.util.BaseFilterRequestDTO;
import com.hbdev.carvalueestimatorbackend.util.PageResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CarService {

    private final CarRepository carRepository;

    protected CarMapper getCarMapper() {
        return CarMapper.INSTANCE;
    }

    public CarResponseDTO estimateCarValue(CarRequestDTO carRequestDTO) {
        CarEntity carEntity = getCarMapper().requestDtoToEntity(carRequestDTO);
        // TODO: Create rest client for ml model here.
        carEntity.setEstimatedValue(Long.valueOf(30000));
        return getCarMapper().entityToResponseDto(carRepository.save(carEntity));
    }

    public void removeCar(Long id) {
        carRepository.deleteById(id);
    }

    public PageResponseDTO<CarResponseDTO> getAllPageable(BaseFilterRequestDTO baseFilterRequestDTO) {
        Pageable pageable;
        if (baseFilterRequestDTO.getSortDTO() != null) {
            if (baseFilterRequestDTO.getSortDTO().getDirectionEnum() == Sort.Direction.ASC) {
                pageable = PageRequest.of(baseFilterRequestDTO.getPageNumber(), baseFilterRequestDTO.getPageSize(),
                        Sort.by(baseFilterRequestDTO.getSortDTO().getColumnName()).ascending());
            } else {
                pageable = PageRequest.of(baseFilterRequestDTO.getPageNumber(), baseFilterRequestDTO.getPageSize(),
                        Sort.by(baseFilterRequestDTO.getSortDTO().getColumnName()).descending());
            }
        } else {
            pageable = PageRequest.of(baseFilterRequestDTO.getPageNumber(), baseFilterRequestDTO.getPageSize(),
                    Sort.by("id").ascending());
        }

        Page<CarEntity> entityPage = carRepository.findAll(pageable);
        PageResponseDTO<CarResponseDTO> responseDTO = new PageResponseDTO<>();
        responseDTO.setTotalElements(entityPage.getTotalElements());
        responseDTO.setTotalPages(entityPage.getTotalPages());
        responseDTO.setSize(entityPage.getSize());

        responseDTO.setSort(entityPage.getSort());
        responseDTO.setNumber(entityPage.getNumber());
        responseDTO.setHasContent(entityPage.hasContent());
        responseDTO.setContent(getCarMapper().entityListToResponseDtoList(entityPage.getContent()));
        entityPage.get().map(entity -> getCarMapper().entityToResponseDto(entity)).collect(Collectors.toList());
        return responseDTO;
    }
}
