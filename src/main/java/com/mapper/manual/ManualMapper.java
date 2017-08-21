package com.mapper.manual;

import com.mapper.db.CountryRepository;
import com.mapper.model.input.Address;
import com.mapper.model.input.Property;
import com.mapper.model.input.Valuation;
import com.mapper.model.output.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ManualMapper {


    public OutputValuation map(Valuation valuation) {

        Property inputProperty = valuation.getProperty();
        Address address = inputProperty.getAddress();

        List<OutputRisk> outputRisks = valuation.getRisks().stream()
                .map(r -> new OutputRisk(r.getName(), r.getValue()))
                .collect(Collectors.toList());

        OutputContact buyer = valuation.getContacts().stream()
                .filter(c -> Objects.equals(c.getRole(), "buyer"))
                .findFirst()
                .map(x -> new OutputContact(x.getName(), x.getRole()))
                .get();

        OutputContact seller = valuation.getContacts().stream()
                .filter(c -> Objects.equals(c.getRole(), "seller"))
                .findFirst()
                .map(x -> new OutputContact(x.getName(), x.getRole()))
                .get();

        OutputValuation outputValuation = new OutputValuation(
                valuation.getReference(),
                valuation.getSupplier(),
                valuation.getPremium() == Boolean.TRUE ? "Y" : "N",
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

        outputValuation.setReference(valuation.getReference());
        return outputValuation;
    }
}
