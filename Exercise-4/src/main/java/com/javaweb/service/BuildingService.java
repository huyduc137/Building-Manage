package com.javaweb.service;

import com.javaweb.model.dto.AssignmentBuildingDTO;
import com.javaweb.model.dto.BuildingDTO;
import com.javaweb.model.response.ResponseDTO;

import java.util.List;

public interface BuildingService {
    ResponseDTO listStaffs(Long buildingId);
    ResponseDTO updateOrAddBuilding(BuildingDTO buildingDTO);
    ResponseDTO deleteBuilding(List<Long> ids);
    ResponseDTO assignmentBuilding(AssignmentBuildingDTO assignmentBuildingDTO);
}
