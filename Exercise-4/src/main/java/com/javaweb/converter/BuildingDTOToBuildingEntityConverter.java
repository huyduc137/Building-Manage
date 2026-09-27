package com.javaweb.converter;

import com.javaweb.entity.BuildingEntity;
import com.javaweb.entity.RentAreaEntity;
import com.javaweb.model.dto.BuildingDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BuildingDTOToBuildingEntityConverter {

    @Autowired
    private ModelMapper modelMapper;
    public BuildingEntity buildingDTOToBuildingEntity(BuildingDTO buildingDTO) {
        BuildingEntity buildingEntity = modelMapper.map(buildingDTO, BuildingEntity.class);
        if (buildingDTO.getTypeCode() != null) {
            String listTypeCode = String.join(",", buildingDTO.getTypeCode());
            buildingEntity.setTypeCode(listTypeCode);
        }

        String[] rentAreas = buildingDTO.getRentArea().trim().split("\\s*,\\s*");
        List<RentAreaEntity> rentAreaEntityList = new ArrayList<>();
        for (String rentArea : rentAreas) {
            if (!rentArea.isEmpty()) {
                RentAreaEntity rentAreaEntity = new RentAreaEntity();
                rentAreaEntity.setValue(Long.parseLong(rentArea));
                rentAreaEntity.setBuildingEntity(buildingEntity);
                rentAreaEntityList.add(rentAreaEntity);
            }
        }
        buildingEntity.setRentAreaEntities(rentAreaEntityList);
        return buildingEntity;
    }
}
