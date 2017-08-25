package com.mapper.selma;

import com.mapper.model.output.OutputValuation;
import com.mapper.testdata.OutputValuationObjectMother;
import com.mapper.testdata.ValuationObjectMother;
import fr.xebia.extras.selma.Selma;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by yangliu on 25/08/2017.
 */
public class SelmaMapperTest {

    @Test
    public void test() {
        SelmaMapper mapper = Selma.builder(SelmaMapper.class).build();
        OutputValuation outputValuation = mapper.asValuation(ValuationObjectMother.createBasicValuation());
        assertThat(outputValuation).isEqualTo(OutputValuationObjectMother.createBasicValuation());
    }
}
