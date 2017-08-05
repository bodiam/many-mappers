package com.mapper.manual;

import com.mapper.model.input.Address;
import com.mapper.model.input.Property;
import com.mapper.model.input.PropertyType;
import com.mapper.model.output.OutputProperty;
import org.junit.Test;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;

public class ManualMapperTest {

    private final ManualMapper manualMapper = new ManualMapper();

    @Test
    public void mapProperty() {
        OutputProperty mappedProperty = manualMapper.map(new Property(PropertyType.APARTMENT, new Address(), Collections.emptyList()));

        assertThat(mappedProperty)
                .extracting("type")
                .contains("APARTMENT");
    }
}