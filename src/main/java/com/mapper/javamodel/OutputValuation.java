package com.mapper.javamodel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * Created by yangliu on 25/08/2017.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OutputValuation {
    private String reference;
    private String supplierCode;
    private String premium;
    //private OutputProperty property;
    private LocalDate dateCreated;
    private Integer amountInCent;
    //private List<OutputRisk> risks;
    //private OutputContact buyer;
    //private OutputContact seller;
}
