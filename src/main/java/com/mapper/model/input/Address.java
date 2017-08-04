package com.mapper.model.input;

import lombok.Data;

@Data
public class Address {

    private String streetName;
    private String unitNumber;
    private String state;
    private String zipCode;
    private Country country;
}
