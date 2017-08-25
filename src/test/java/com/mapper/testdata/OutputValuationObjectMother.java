package com.mapper.testdata;

import com.mapper.model.output.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;

public class OutputValuationObjectMother {

    public static OutputValuation createBasicValuation() {
        return new OutputValuation(
                "reference",
                "supplier",
                "Y",
                null,
                "2010-10-03",
                Collections.emptyList(),
                null,
                null
        );
    }


    public static OutputValuation createOutputValuation() {

        return new OutputValuation(
                "reference",
                "supplier",
                "Y",
                new OutputProperty(
                        "apartment",
                        new OutputAddress(
                                "unitNumber streetName zipCode state",
                                "Australia"
                        ),
                        Arrays.asList(
                                new OutputEstimate(
                                        "customer",
                                        new OutputAmount(
                                                new BigDecimal("100000"),
                                                "AUD"
                                        )
                                )
                        )
                ),
                "2010-10-03",
                Arrays.asList(
                        new OutputRisk(
                                "fire",
                                100
                        )
                ),
                new OutputContact(
                        "kevin",
                        "buyer"
                ),
                new OutputContact(
                        "diana",
                        "seller"
                )
        );

    }
}
