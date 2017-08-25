package com.mapper.javamodel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Created by yangliu on 25/08/2017.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Valuation {
    private String reference;
    private String supplier;
    private boolean premium;
    //private Property property;
    private LocalDateTime dateCreated;
    private BigDecimal amountInDollar;
    //private List<Risk> risks;
    //private List<Contact> contacts;

}
