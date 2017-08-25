package com.mapper.mapstruct;

import com.mapper.model.input.Address;

public class AddressUtil {

    @AddressAnnotation
    public String convert(Address address) {
        return address.getUnitNumber() + " " + address.getStreetName() + " " + address.getZipCode() + " " + address.getState();
    }


}
