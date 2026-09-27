package com.javaweb.api.admin;

import com.javaweb.model.dto.AssignmentBuildingDTO;
import com.javaweb.model.dto.BuildingDTO;
import com.javaweb.model.response.ResponseDTO;
import com.javaweb.service.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController(value = "buildingAPIOfAdmin")
@RequestMapping("/api/building")
public class BuildingAPI {
    @Autowired
    private BuildingService buildingService;


    @PostMapping
    public ResponseDTO addOrUpdateBuilding(@RequestBody BuildingDTO buildingDTO) {
        ResponseDTO responseDTO = buildingService.updateOrAddBuilding(buildingDTO);
        return responseDTO;
    }

    @DeleteMapping("/{ids}")
    public ResponseDTO deleteBuildings(@PathVariable List<Long> ids) {
        ResponseDTO responseDTO = buildingService.deleteBuilding(ids);
        return responseDTO;
    }

    @GetMapping("/{id}/staffs")
    public ResponseDTO loadStaffs(@PathVariable Long id) {
        ResponseDTO result = buildingService.listStaffs(id);
        return result;
    }

    @PostMapping("/assignment")
    public ResponseDTO updateAssignmentBuilding(@RequestBody AssignmentBuildingDTO assignmentBuildingDTO) {
        ResponseDTO responseDTO = buildingService.assignmentBuilding(assignmentBuildingDTO);
        return responseDTO;
    }

}
