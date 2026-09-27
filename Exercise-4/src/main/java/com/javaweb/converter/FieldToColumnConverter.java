package com.javaweb.converter;

import java.util.HashMap;
import java.util.Map;

public class FieldToColumnConverter {
    private static final Map<String, String> FIELD_TO_COLUMN = new HashMap<>();
    static {
        FIELD_TO_COLUMN.put("name", "name");
        FIELD_TO_COLUMN.put("floorArea", "floorarea");
        FIELD_TO_COLUMN.put("ward", "ward");
        FIELD_TO_COLUMN.put("street", "street");
        FIELD_TO_COLUMN.put("numberOfBasement", "numberofbasement");
        FIELD_TO_COLUMN.put("direction", "direction");
        FIELD_TO_COLUMN.put("level", "level");
        FIELD_TO_COLUMN.put("managerName", "managername");
        FIELD_TO_COLUMN.put("managerPhone", "managerphone");
    }

    public static String getColumn(String fieldName) {
        if (fieldName != null) {
            return FIELD_TO_COLUMN.get(fieldName);
        }
        return null;
    }
}
