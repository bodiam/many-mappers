package com.mapper.manual;

import com.mapper.model.input.Property;
import com.mapper.model.output.OutputProperty;

public class ManualMapper {


    public OutputProperty map(Property property) {
        OutputProperty outputProperty = new OutputProperty();
        outputProperty.setType(property.getPropertyType().name());
        return outputProperty;
    }
}
