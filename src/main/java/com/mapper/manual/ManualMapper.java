package com.mapper.manual;

import com.mapper.db.CountryRepository;
import com.mapper.model.input.Address;
import com.mapper.model.input.Property;
import com.mapper.model.input.Valuation;
import com.mapper.model.output.*;
import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.lang.Boolean.TRUE;

public class ManualMapper {


    public OutputValuation map(Valuation valuation) {

        Property inputProperty = valuation.getProperty();
        Address address = inputProperty.getAddress();

        List<OutputRisk> outputRisks = valuation.getRisks().stream()
                .map(r -> new OutputRisk(r.getName(), r.getValue()))
                .collect(Collectors.toList());

        OutputContact buyer = getByRole(valuation, "buyer");
        OutputContact seller = getByRole(valuation, "seller");

        return new OutputValuation(
                valuation.getReference(),
                valuation.getSupplier(),
                valuation.getPremium() == TRUE ? "Y" : "N",
                new OutputProperty(
                        inputProperty.getPropertyType().toString().toLowerCase(),
                        new OutputAddress(
                                address.getUnitNumber() + " " + address.getStreetName() + " " + address.getZipCode() + " " + address.getState(),
                                CountryRepository.getCountryByIso3(address.getCountry().toString())
                        ),
                        inputProperty.getEstimates()
                                .stream()
                                .map(e -> new OutputEstimate(e.getSource(), new OutputAmount(e.getAmount().getValueInCents().divide(new BigDecimal(100)), e.getAmount().getCurrency())))
                                .collect(Collectors.toList())
                ),
                valuation.getDateCreated().toLocalDate(),
                outputRisks,
                buyer,
                seller

        );
    }

    private OutputContact getByRole(Valuation valuation, String role) {
        return valuation.getContacts().stream()
                .filter(c -> Objects.equals(c.getRole(), role))
                .findFirst()
                .map(x -> new OutputContact(x.getName(), x.getRole()))
                .orElse(null);
    }
}
