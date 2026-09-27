package com.javaweb.repository.custom;

import com.javaweb.entity.BuildingEntity;
import com.javaweb.model.request.BuildingSearchRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BuildingSearchRepositoryCustom {
    List<BuildingEntity> findBuilding(BuildingSearchRequest buildingSearchRequest);
}
