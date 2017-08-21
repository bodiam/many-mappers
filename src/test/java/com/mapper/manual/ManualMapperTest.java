package com.mapper.manual;

import com.mapper.model.output.OutputValuation;
import com.mapper.testdata.OutputValuationObjectMother;
import com.mapper.testdata.ValuationObjectMother;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ManualMapperTest {

    private final ManualMapper manualMapper = new ManualMapper();

    @Test
    public void mapProperty() {
        OutputValuation mappedValuation = manualMapper.map(ValuationObjectMother.createValuation());

        assertThat(mappedValuation).isEqualTo(OutputValuationObjectMother.createOutputValuation());
    }

}