package com.javaweb.service;

import com.javaweb.model.dto.BuildingDTO;
import com.javaweb.model.request.BuildingSearchRequest;
import com.javaweb.model.response.BuildingSearchResponse;

import java.util.List;

public interface BuildingSearchService {
    List<BuildingSearchResponse> buildingSearchResponse(BuildingSearchRequest buildingSearchRequest);
    BuildingDTO searchBuildingById(Long buildingId);

}
