package com.javaweb.service.impl;

import com.javaweb.converter.BuildingEntityToBuildingConverter;
import com.javaweb.entity.BuildingEntity;
import com.javaweb.model.dto.BuildingDTO;
import com.javaweb.model.request.BuildingSearchRequest;
import com.javaweb.model.response.BuildingSearchResponse;
import com.javaweb.repository.BuildingRepository;
import com.javaweb.service.BuildingSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BuildingSearchServiceImpl implements BuildingSearchService {
    @Autowired
    private BuildingRepository buildingRepository;
    @Autowired
    private BuildingEntityToBuildingConverter buildingEntityToBuildingConverter;

    @Override
    public List<BuildingSearchResponse> buildingSearchResponse(BuildingSearchRequest buildingSearchRequest) {
        List<BuildingEntity> buildingEntities = buildingRepository.findBuilding(buildingSearchRequest);
        List<BuildingSearchResponse> result = new ArrayList<>();
        for (BuildingEntity item : buildingEntities) {
            BuildingSearchResponse building = buildingEntityToBuildingConverter.buildingEntityToBuildingSearchResponseConverter(item);
            result.add(building);
        }
        return result;
    }

    @Override
    public BuildingDTO searchBuildingById(Long buildingId) {
        BuildingEntity buildingEntity = buildingRepository.findById(buildingId).get();
        BuildingDTO buildingDTO = buildingEntityToBuildingConverter.buildingEntityToBuildingDTO(buildingEntity);
        return buildingDTO;
    }
}
