package com.mapper.manual;

import com.mapper.db.CountryRepository;
import com.mapper.model.input.*;
import com.mapper.model.output.*;
import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.lang.Boolean.TRUE;

public class ManualMapper {


    public OutputValuation map(Valuation valuation) {

        Billing billingDetails = valuation.getBillingDetails();

        return new OutputValuation(
                valuation.getReference(),
                valuation.getSupplier(),
                valuation.getPremium() == TRUE ? "Y" : "N",
                createProperty(valuation.getProperty()),
                valuation.getDateCreated().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")),
                createRisks(valuation),
                getByRole(valuation.getContacts(), "buyer"),
                getByRole(valuation.getContacts(), "seller"),
                createAppointment(valuation),
                billingDetails.getName(),
                billingDetails.getPaymentType(),
                billingDetails.getAccount()
        );
    }

    private OutputAppointment createAppointment(Valuation valuation) {
        return new OutputAppointment(
                valuation.getAppointmentInstructions(),
                valuation.getAppointmentDateTime(),
                valuation.getAppointmentContactNumber()
        );
    }

    private List<OutputRisk> createRisks(Valuation valuation) {
        return valuation.getRisks().stream()
                .map(r -> new OutputRisk(r.getName(), r.getValue()))
                .collect(Collectors.toList());
    }

    @NotNull
    private OutputProperty createProperty(Property inputProperty) {
        return new OutputProperty(
                inputProperty.getPropertyType().toString().toLowerCase(),
                createAddress(inputProperty.getAddress()),
                inputProperty.getEstimates().stream()
                        .map(e -> new OutputEstimate(e.getSource(), new OutputAmount(e.getAmount().getValueInCents().divide(new BigDecimal(100)), e.getAmount().getCurrency())))
                        .collect(Collectors.toList())
        );
    }

    @NotNull
    private OutputAddress createAddress(Address address) {
        return new OutputAddress(
                address.getUnitNumber() + " " + address.getStreetName() + " " + address.getZipCode() + " " + address.getState(),
                CountryRepository.getCountryByIso3(address.getCountry().toString())
        );
    }

    @NotNull
    private OutputContact getByRole(List<Contact> contacts, String role) {
        return contacts.stream()
                .filter(c -> Objects.equals(c.getRole(), role))
                .findFirst()
                .map(x -> new OutputContact(x.getName(), x.getRole()))
                .orElseThrow(() -> new IllegalArgumentException("Coudln't find contact with role " + role));
    }
}
