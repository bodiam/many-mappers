package com.mapper.orika;

import com.mapper.model.output.OutputValuation;
import com.mapper.testdata.OutputValuationObjectMother;
import com.mapper.testdata.ValuationObjectMother;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class OrikaMapperTest {

    private final OrikaMapper mapper = new OrikaMapper();

    @Test
    public void mapBasicValuation() {

        OutputValuation outputValuation = mapper.map(ValuationObjectMother.createBasicValuation());
        assertThat(outputValuation).isEqualTo(OutputValuationObjectMother.createBasicValuation());

    }

}
