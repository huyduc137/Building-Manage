package com.javaweb.service.impl;

import com.javaweb.converter.BuildingDTOToBuildingEntityConverter;
import com.javaweb.entity.BuildingEntity;
import com.javaweb.entity.UserEntity;
import com.javaweb.model.dto.AssignmentBuildingDTO;
import com.javaweb.model.dto.BuildingDTO;
import com.javaweb.model.response.ResponseDTO;
import com.javaweb.model.response.StaffResponseDTO;
import com.javaweb.repository.BuildingRepository;
import com.javaweb.repository.RentAreaRepository;
import com.javaweb.repository.UserRepository;
import com.javaweb.service.BuildingService;
import com.javaweb.service.RentAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class BuildingServiceImpl implements BuildingService {
    @Autowired
    private BuildingRepository buildingRepositoty;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RentAreaRepository rentAreaRepository;
    @Autowired
    private RentAreaService rentAreaService;
    @Autowired
    private BuildingDTOToBuildingEntityConverter buildingDTOToBuildingEntityConverter;

    @Override
    public ResponseDTO listStaffs(Long buildingId) {
        ResponseDTO responseDTO = new ResponseDTO();
        BuildingEntity building = buildingRepositoty.findById(buildingId).get();
        List<UserEntity> staffAll = userRepository.findByStatusAndRoles_Code(1, "STAFF");
        List<UserEntity> staffAssignBuilding = building.getStaffs();
        List<StaffResponseDTO> listStaffResponse = new ArrayList<>();
        for (UserEntity staff : staffAll) {
            StaffResponseDTO staffResponseDTO = new StaffResponseDTO();
            staffResponseDTO.setFullName(staff.getFullName());
            staffResponseDTO.setStaffId(staff.getId());
            if (staffAssignBuilding.contains(staff)) {
                staffResponseDTO.setChecked("checked");
            }
            else {
                staffResponseDTO.setChecked("");
            }
            listStaffResponse.add(staffResponseDTO);
        }
        responseDTO.setData(listStaffResponse);
        responseDTO.setMessage("khong biet tra ra duoc khong!!!");
        return responseDTO;
    }

    @Override
    public ResponseDTO updateOrAddBuilding(BuildingDTO buildingDTO) {
        BuildingEntity buildingEntity = buildingDTOToBuildingEntityConverter.buildingDTOToBuildingEntity(buildingDTO);
        if (buildingDTO.getId() != null) {
            rentAreaRepository.deleteByBuildingEntityId(buildingEntity.getId());
        }
        buildingRepositoty.save(buildingEntity);
        rentAreaService.addRentArea(buildingEntity);
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setMessage(buildingDTO.getId() == null ? "Thêm mới thành côngg" : "Cập nhật thành công");
        return responseDTO;
    }

    @Override
    @Transactional
    public ResponseDTO deleteBuilding(List<Long> ids) {
        for (Long id : ids) {
            rentAreaRepository.deleteByBuildingEntityId(id);
            buildingRepositoty.deleteById(id);
        }
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setMessage("Xóa thành công!");
        return responseDTO;
    }

    @Override
    @Transactional
    public ResponseDTO assignmentBuilding(AssignmentBuildingDTO assignmentBuildingDTO) {
        ResponseDTO responseDTO = new ResponseDTO();
        BuildingEntity building = buildingRepositoty.findById(assignmentBuildingDTO.getBuildingId())
                .orElseThrow(() -> new RuntimeException("Không tìm thấy tòa nhà"));
        List<UserEntity> listStaff = userRepository.findByIdIn(assignmentBuildingDTO.getStaffs());
        building.setStaffs(listStaff);
        buildingRepositoty.save(building);
        responseDTO.setMessage("giao tòa nhà cho nhân viên thành công!!!");
        return responseDTO;
    }
}
