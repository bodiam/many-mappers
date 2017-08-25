package com.mapper.mapstruct;

import com.mapper.model.input.Valuation;
import com.mapper.model.output.OutputValuation;
import com.mapper.testdata.OutputValuationObjectMother;
import com.mapper.testdata.ValuationObjectMother;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MapstructTest {


    @Test
    public void testSimpleMap() {
        Valuation basicValuation = ValuationObjectMother.createBasicValuation();
        OutputValuation outputValuation = ValuationMapper.INSTANCE.map(basicValuation);
        assertThat(outputValuation).isEqualTo(OutputValuationObjectMother.createBasicValuation());
    }
    @Test
    public void testComplexMap() {
        Valuation valuation = ValuationObjectMother.createValuation();
        OutputValuation outputValuation = ValuationMapper.INSTANCE.map(valuation);
        assertThat(outputValuation).isEqualTo(OutputValuationObjectMother.createOutputValuation());
    }
}
