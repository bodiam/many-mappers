package com.mapper.testdata;

import com.mapper.model.input.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Collections;

import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;

public class ValuationObjectMother {


    public static Valuation createBasicValuation() {
        return new Valuation(
                "reference",
                "supplier",
                Boolean.TRUE,
                null,
                LocalDateTime.of(2010, 10, 3, 4, 55),
                Collections.emptyList(),
                Collections.emptyList(),
                "last house on the left",
                null,
                null,
                null
        );
    }

    public static Valuation createValuation() {
        return new Valuation(
                "reference",
                "supplier",
                Boolean.TRUE,
                new Property(
                        PropertyType.APARTMENT,
                        new Address(
                                "streetName",
                                "unitNumber",
                                "state",
                                "zipCode",
                                Country.AUS
                        ),
                        singletonList(
                                new Estimate(
                                        "customer",
                                        new Amount(
                                                new BigDecimal("10000000"),
                                                "AUD"
                                        )
                                )
                        )
                ),
                LocalDateTime.of(2010, 10, 3, 4, 55),
                singletonList(
                        new Risk(
                                "fire",
                                100
                        )
                ),
                asList(
                        new Contact(
                                "erik",
                                "advisor"
                        ),
                        new Contact(
                                "kevin",
                                "buyer"
                        ),
                        new Contact(
                                "diana",
                                "seller"
                        )
                ),
                "please use the left door",
                LocalDateTime.of(2015, 11, 1, 4, 55),
                "0123456789",
                new Billing(
                        "rick",
                        "credit card",
                        "1234 5678 9012 4444"
                )
        );

    }
}
