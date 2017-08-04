package com.mapper.model.output;

import com.mapper.model.input.Contact;

import java.time.LocalDate;
import java.util.List;

public class Valuation {

    private String reference;
    private String supplierCode;
    private String premium;

    private Property property;
    private LocalDate dateCreated;

    private List<Risk> risks;

    private Contact buyer;
    private Contact seller;

}
