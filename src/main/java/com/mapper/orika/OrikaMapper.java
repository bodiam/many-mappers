package com.mapper.orika;

import com.mapper.model.input.Valuation;
import com.mapper.model.output.OutputValuation;
import ma.glasnost.orika.CustomConverter;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.MappingContext;
import ma.glasnost.orika.converter.ConverterFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import ma.glasnost.orika.metadata.Type;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class OrikaMapper {

    final MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();

    public OrikaMapper() {
        mapperFactory.classMap(Valuation.class, OutputValuation.class)
                .field("supplier", "supplierCode")
                .byDefault()
                .register();

        ConverterFactory converterFactory = mapperFactory.getConverterFactory();
        converterFactory.registerConverter(new LocalDateTimeToLocalDateConverter());
        converterFactory.registerConverter(new BooleanToYesNoConverter());
    }

    class LocalDateTimeToLocalDateConverter extends CustomConverter<LocalDateTime, LocalDate> {
        @Override
        public LocalDate convert(LocalDateTime source, Type<? extends LocalDate> destinationType, MappingContext mappingContext) {
            return source.toLocalDate();
        }
    }

    class BooleanToYesNoConverter extends CustomConverter<Boolean, String> {
        @Override
        public String convert(Boolean source, Type<? extends String> destinationType, MappingContext mappingContext) {
            return source == Boolean.TRUE ? "Y" : "N";
        }
    }


    public OutputValuation map(Valuation valuation) {

        MapperFacade mapper = mapperFactory.getMapperFacade();

        return mapper.map(valuation, OutputValuation.class);
    }
}
