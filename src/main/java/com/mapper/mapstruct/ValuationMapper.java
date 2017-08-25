package com.mapper.mapstruct;


import com.mapper.model.input.*;
import com.mapper.model.output.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ValuationMapper {

    ValuationMapper INSTANCE = Mappers.getMapper(ValuationMapper.class);


    @Mappings({
            @Mapping(source = "supplier", target = "supplierCode"),
            @Mapping(target = "buyer", ignore = true),
            @Mapping(target = "seller", ignore = true),
            @Mapping(target = "dateCreated", dateFormat = "yyyy-MM-dd"),
            @Mapping(target= "premium", expression = "java(valuation.getPremium() == true ? \"Y\" : \"N\")")
    })
    OutputValuation map(Valuation valuation);

    @Mappings({@Mapping(source = "propertyType", target = "type")})
    OutputProperty map(Property property);

    @Mapping(target = "fullAddress", expression = "java(address.getUnitNumber() + \" \" + address.getStreetName() + \" \" + address.getZipCode() + \" \" + address.getState())")
    OutputAddress map(Address address);

    List<OutputEstimate> mapEstimates(List<Estimate> estimates);

    OutputEstimate map(Estimate estimate);

    List<OutputContact> mapContact(List<Contact> contacts);

    OutputContact map(Contact contact);

    @Mapping( target = "valueInDollar", expression = "java(amount.getValueInCents().divide(new java.math.BigDecimal(100)))")
    OutputAmount map(Amount amount);

    OutputRisk map(Risk risk);
}
