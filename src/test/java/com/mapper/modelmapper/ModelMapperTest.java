package com.mapper.modelmapper;

import com.mapper.javamodel.OutputValuation;
import com.mapper.javamodel.Valuation;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by yangliu on 25/08/2017.
 */
public class ModelMapperTest {

    @Test
    public void test() {
        MyModelMapper myModelMapper = new MyModelMapper();
        Valuation valuation = Valuation.builder()
                .reference("reference")
                .supplier("supplier")
                .premium(true)
                .dateCreated(LocalDateTime.now())
                .amountInDollar(new BigDecimal(100))
                .build();
        OutputValuation expectedOutputValuation = OutputValuation.builder()
                .reference("reference")
                .supplierCode("supplier")
                .premium("true")
                .dateCreated(LocalDate.now())
                .amountInCent(10000)
                .build();
        OutputValuation outputValuation = myModelMapper.map(valuation);
        assertThat(outputValuation).isEqualTo(expectedOutputValuation);
    }
}
