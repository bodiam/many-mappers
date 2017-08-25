package com.mapper.modelmapper;

import com.mapper.javamodel.OutputValuation;
import com.mapper.javamodel.Valuation;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Created by yangliu on 24/08/2017.
 */
public class MyModelMapper {

    public OutputValuation map(Valuation valuation) {
        ModelMapper modelMapper = new ModelMapper();
//        modelMapper.addMappings(Valuation::getSupplier, OutputValuation::getReference);
//        modelMapper.addMappings(mapper -> {
//            mapper.map(Valuation::getSupplier, OutputValuation::setReference);
//        });
        Converter<LocalDateTime, LocalDate> dateConverter = context -> context.getSource().toLocalDate();
        Converter<BigDecimal, Integer> amountConverter = context -> context.getSource().multiply(new BigDecimal(100)).intValue();

        PropertyMap<Valuation, OutputValuation> nameMap = new PropertyMap<Valuation, OutputValuation>() {
            protected void configure() {
                map().setSupplierCode(source.getSupplier());
            }
        };
        PropertyMap<Valuation, OutputValuation> dateMap = new PropertyMap<Valuation, OutputValuation>() {
            protected void configure() {
                using(dateConverter).map(source.getDateCreated(), destination.getDateCreated());
                //map().setDateCreated(source.getDateCreated().toLocalDate());
            }
        };
        PropertyMap<Valuation, OutputValuation> amountMap = new PropertyMap<Valuation, OutputValuation>() {
            protected void configure() {
                using(amountConverter).map(source.getAmountInDollar(), destination.getAmountInCent());
            }
        };
        modelMapper.addMappings(nameMap);
        modelMapper.addMappings(dateMap);
        modelMapper.addMappings(amountMap);
//        modelMapper.addConverter(dateConverter);
//        modelMapper.addConverter(amountConverter);
        OutputValuation outputValuation = modelMapper.map(valuation, OutputValuation.class);
        return outputValuation;
    }
}
