package com.mapper.testdata;

import com.mapper.model.input.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;

public class ValuationObjectMother {


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
                )
        );

    }
}