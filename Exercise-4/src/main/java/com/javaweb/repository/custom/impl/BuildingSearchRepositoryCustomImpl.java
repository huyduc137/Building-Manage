package com.javaweb.repository.custom.impl;

import com.javaweb.converter.FieldToColumnConverter;
import com.javaweb.entity.BuildingEntity;
import com.javaweb.model.request.BuildingSearchRequest;
import com.javaweb.repository.custom.BuildingSearchRepositoryCustom;
import com.javaweb.utils.NumberUtils;
import com.javaweb.utils.StringUtils;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

@Repository
@Primary
public class BuildingSearchRepositoryCustomImpl implements BuildingSearchRepositoryCustom {
    @PersistenceContext
    private EntityManager entityManager;

    public static void handleJoin(StringBuilder sql) {
        // diện tích thuê rentarea
        // Nhân viên assignmentbuilding
        sql.append("LEFT JOIN rentarea AS r ON b.id = r.buildingid ");
        sql.append("LEFT JOIN assignmentbuilding AS ass ON b.id = ass.buildingid ");
    }
    public static void handleNormal(StringBuilder where, BuildingSearchRequest buildingSearchRequest) {
        try {
            Field[] fields = BuildingSearchRequest.class.getDeclaredFields();
            for (Field item : fields) {
                item.setAccessible(true);
                String fieldName = item.getName();
                String column = FieldToColumnConverter.getColumn(fieldName);
                Object value = item.get(buildingSearchRequest);
                if (column != null) {
                    if (column.equals("managerphone")) {
                        if (value != null) {
                            String val = value.toString();
                            where.append("AND b." + column + " like '%" + val + "%' ");
                        }
                    }
                    continue;
                }
                if (!fieldName.equals("areaFrom") && !fieldName.equals("areaTo")
                        && !fieldName.equals("rentPriceFrom")
                        && !fieldName.equals("rentPriceTo")
                        && !fieldName.equals("staffCode")
                        && !fieldName.equals("typeCode")){
                    if (value != null) {
                        String val = value.toString();
                        if (StringUtils.check(val)) {
                            if (NumberUtils.isLong(val)) {
                                where.append("AND b." + column + " = " + val + " ");
                            }
                            else {
                                where.append("AND b." + column + " like '%" + val + "%' ");
                            }
                        }
                    }
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public static void handleSpecial(StringBuilder where, BuildingSearchRequest buildingSearchRequest) {
        Long valueAreaFrom = buildingSearchRequest.getAreaFrom();
        Long valueAreaTo = buildingSearchRequest.getAreaTo();
        if (valueAreaFrom != null) {
            where.append("AND r.value >= " + valueAreaFrom + " ");
        }
        if (valueAreaTo != null) {
            where.append("AND r.value <= " + valueAreaTo + " ");
        }
        Long valuePriceFrom = buildingSearchRequest.getRentPriceFrom();
        if (valuePriceFrom != null) {
            where.append("AND b.rentprice >= " + valuePriceFrom + " ");
        }
        Long valuePriceTo = buildingSearchRequest.getRentPriceTo();
        if (valuePriceTo != null) {
            where.append("AND b.rentprice <= " + valuePriceTo + " ");
        }
        Long staffId = buildingSearchRequest.getStaffId();
        if (staffId != null) {
            where.append("AND ass.staffid = " + staffId + " ");
        }
        List<String> typeCodes = buildingSearchRequest.getTypeCode();
        if (typeCodes != null && typeCodes.size() != 0) {
            for (String typeCode : typeCodes) {
                where.append("AND b.type like '%" + typeCode + "%' ");
            }
        }
    }
    public static void handleGroupBy(StringBuilder where) {
        where.append("GROUP BY b.id ");
    }
    @Override
    public List<BuildingEntity> findBuilding(BuildingSearchRequest buildingSearchRequest) {
        StringBuilder sql = new StringBuilder("SELECT b.* ");
        sql.append("FROM estateadvance.building AS b ");
        handleJoin(sql);
        StringBuilder where = new StringBuilder("WHERE 1 = 1 ");
        handleNormal(where, buildingSearchRequest);
        handleSpecial(where, buildingSearchRequest);
        handleGroupBy(where);
        sql.append(where);
        System.out.println(sql);
        List <BuildingEntity> results = new ArrayList<>();
        Query query = entityManager.createNativeQuery(sql.toString(), BuildingEntity.class);
        results = query.getResultList();
        return results;
    }

}
