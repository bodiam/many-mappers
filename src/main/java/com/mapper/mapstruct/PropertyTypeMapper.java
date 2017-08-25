package com.mapper.mapstruct;

import com.mapper.model.input.PropertyType;

public class PropertyTypeMapper {
    public String map(PropertyType propertyType) {
        return propertyType.toString().toLowerCase();
    }
}
