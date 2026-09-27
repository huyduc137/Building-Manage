package com.javaweb.converter;

import com.javaweb.entity.BuildingEntity;
import com.javaweb.entity.RentAreaEntity;
import com.javaweb.enums.DistrictCode;
import com.javaweb.model.dto.BuildingDTO;
import com.javaweb.model.response.BuildingSearchResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BuildingEntityToBuildingConverter {
    @Autowired
    private ModelMapper modelMapper;

    public BuildingDTO buildingEntityToBuildingDTO(BuildingEntity buildingEntity) {
        BuildingDTO buildingDTO = modelMapper.map(buildingEntity, BuildingDTO.class);
        List<String> typeCodeList = new ArrayList<>();
        if (buildingEntity.getTypeCode() != null) {
            String[] typeCode = buildingEntity.getTypeCode().split(",");
            if (typeCode != null) {
                for (String type : typeCode) {
                    typeCodeList.add(type);
                }
                buildingDTO.setTypeCode(typeCodeList);
            }
        }
        List<String> listRentArea = new ArrayList<>();
        List<RentAreaEntity> rentAreaEntitys = buildingEntity.getRentAreaEntities();
        if (rentAreaEntitys != null) {
            for (RentAreaEntity rentAreaEntity : rentAreaEntitys) {
                listRentArea.add(String.valueOf(rentAreaEntity.getValue()));
            }
            String rentArea = String.join(", ", listRentArea);
            buildingDTO.setRentArea(rentArea);
        }
        return buildingDTO;
    }

    public BuildingSearchResponse buildingEntityToBuildingSearchResponseConverter(BuildingEntity buildingEntity){
        BuildingSearchResponse buildingSearchResponse = modelMapper.map(buildingEntity, BuildingSearchResponse.class);
        if (buildingEntity.getDistrict() != null) {
            buildingSearchResponse.setAddress(buildingEntity.getStreet() + ", " + buildingEntity.getWard() + ", " + DistrictCode.type().get(buildingEntity.getDistrict()));
        }
        buildingSearchResponse.setEmptyArea("");
        List<RentAreaEntity> rentAreaEntityList = buildingEntity.getRentAreaEntities();
        if (rentAreaEntityList != null) {
            List<String> listRentArea = new ArrayList<>();
            for (RentAreaEntity rentAreaEntity : rentAreaEntityList) {
                listRentArea.add(String.valueOf(rentAreaEntity.getValue()));
            }
            String s = String.join(", ", listRentArea);
            buildingSearchResponse.setRentArea(s);
        }
        return buildingSearchResponse;
    }
}
