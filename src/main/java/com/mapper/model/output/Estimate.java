package com.mapper.model.output;

import com.mapper.model.input.Amount;
import lombok.Data;

@Data
public class Estimate {

    private String source;
    private Amount amount;

}
