package com.mapper.orika;

import com.mapper.db.CountryRepository;
import com.mapper.model.input.*;
import com.mapper.model.output.*;
import ma.glasnost.orika.CustomConverter;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.MappingContext;
import ma.glasnost.orika.converter.ConverterFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import ma.glasnost.orika.metadata.Type;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;

public class OrikaMapper {

    final MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();

    public OrikaMapper() {
        mapperFactory.classMap(Valuation.class, OutputValuation.class)
                .field("supplier", "supplierCode")
                .field("billingDetails.name", "billingContact")
                .field("billingDetails.paymentType", "billingPaymentType")
                .field("billingDetails.account", "accountNumber")
                .field("appointmentInstructions", "appointment.instructions")
                .field("appointmentDateTime", "appointment.dateTime")
                .field("appointmentContactNumber", "appointment.contactNumber")
                .fieldMap("contacts", "buyer").converter("buyerRole").add()
                .fieldMap("contacts", "seller").converter("sellerRole").add()
                .byDefault()
                .register();

        mapperFactory.classMap(Property.class, OutputProperty.class)
                .field("propertyType", "type")
                .byDefault()
                .register();

        ConverterFactory converterFactory = mapperFactory.getConverterFactory();
        converterFactory.registerConverter(new LocalDateTimeToLocalDateConverter());
        converterFactory.registerConverter(new BooleanToYesNoConverter());
        converterFactory.registerConverter(new PropertyTypeConverter());
        converterFactory.registerConverter(new FullAddressConverter());
        converterFactory.registerConverter(new AmountInCentstoDollarConverter());
        converterFactory.registerConverter("buyerRole", new RoleConverter("buyer"));
        converterFactory.registerConverter("sellerRole", new RoleConverter("seller"));
    }



    private class LocalDateTimeToLocalDateConverter extends CustomConverter<LocalDateTime, String> {
        @Override
        public String convert(LocalDateTime source, Type<? extends String> destinationType, MappingContext mappingContext) {
            return source.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        }
    }

    private class BooleanToYesNoConverter extends CustomConverter<Boolean, String> {
        @Override
        public String convert(Boolean source, Type<? extends String> destinationType, MappingContext mappingContext) {
            return source == Boolean.TRUE ? "Y" : "N";
        }
    }

    private class PropertyTypeConverter extends CustomConverter<PropertyType, String> {
        @Override
        public String convert(PropertyType source, Type<? extends String> destinationType, MappingContext mappingContext) {
            return source.name().toLowerCase();
        }
    }

    private class FullAddressConverter extends CustomConverter<Address, OutputAddress> {
        @Override
        public OutputAddress convert(Address source, Type<? extends OutputAddress> destinationType, MappingContext mappingContext) {
            return new OutputAddress(
                    source.getUnitNumber() + " " + source.getStreetName() + " " + source.getZipCode() + " " + source.getState(),
                    CountryRepository.getCountryByIso3(source.getCountry().toString())
            );
        }
    }
    private class AmountInCentstoDollarConverter extends CustomConverter<Amount, OutputAmount> {

        @Override
        public OutputAmount convert(Amount source, Type<? extends OutputAmount> destinationType, MappingContext mappingContext) {
            return new OutputAmount(source.getValueInCents().divide(new BigDecimal(100)), source.getCurrency());
        }
    }

    private class RoleConverter extends CustomConverter<List<Contact>, OutputContact> {

        private String role;

        public RoleConverter(String role) {
            this.role = role;
        }

        @Override
        public OutputContact convert(List<Contact> source, Type<? extends OutputContact> destinationType, MappingContext mappingContext) {
            return source.stream()
                    .filter(c -> Objects.equals(c.getRole(), role))
                    .findFirst()
                    .map(x -> new OutputContact(x.getName(), x.getRole()))
                    .orElse(null);
        }
    }




    public OutputValuation map(Valuation valuation) {

        MapperFacade mapper = mapperFactory.getMapperFacade();

        return mapper.map(valuation, OutputValuation.class);
    }

}
