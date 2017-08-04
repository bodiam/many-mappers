package com.mapper.model.input;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class Valuation {

    private String reference;
    private String supplier;
    private Boolean premium;

    private Property property;
    private LocalDateTime dateCreated;

    private List<Risk> risks;
    private List<Contact> contacts;

}
