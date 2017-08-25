package com.mapper.mapstruct;


import com.mapper.model.input.*;
import com.mapper.model.output.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(uses = {PropertyTypeMapper.class, ContactIterableUtil.class, Iso3ToFullCountryUtil.class, AddressUtil.class})
public interface ValuationMapper {

    ValuationMapper INSTANCE = Mappers.getMapper(ValuationMapper.class);


    @Mappings({
            @Mapping(source = "supplier", target = "supplierCode"),
            @Mapping(target = "buyer", source = "contacts", qualifiedBy = Buyer.class),
            @Mapping(target = "seller", source = "contacts", qualifiedBy = Seller.class),
            @Mapping(target = "dateCreated", dateFormat = "yyyy-MM-dd"),
            @Mapping(target= "premium", expression = "java(valuation.getPremium() == true ? \"Y\" : \"N\")")
    })
    OutputValuation map(Valuation valuation);

    @Mappings({@Mapping(source = "propertyType", target = "type")})
    OutputProperty map(Property property);

    @Mappings({
            @Mapping(target = "fullAddress", source="address", qualifiedBy = AddressAnnotation.class),
            @Mapping(target = "country", source="country" , qualifiedBy = Iso3Country.class)
    })
    OutputAddress map(Address address);

    List<OutputEstimate> mapEstimates(List<Estimate> estimates);

    OutputEstimate map(Estimate estimate);

    List<OutputContact> mapContact(List<Contact> contacts);

    OutputContact map(Contact contact);

    @Mapping( target = "valueInDollar", expression = "java(amount.getValueInCents().divide(new java.math.BigDecimal(100)))")
    OutputAmount map(Amount amount);

    OutputRisk map(Risk risk);
}
