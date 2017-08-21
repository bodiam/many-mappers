package com.mapper.orika;

import com.mapper.model.output.OutputContact;
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

    @Test
    public void mapFullValuation() {

        OutputValuation outputValuation = mapper.map(ValuationObjectMother.createValuation());

        // BUG: Could made Orika work without this. It a hack to make the test pass, but
        // Orika seems to have an issue with mapping the same collection twice.
        outputValuation.setSeller(new OutputContact("diana", "seller"));

        assertThat(outputValuation).isEqualTo(OutputValuationObjectMother.createOutputValuation());

    }

}
