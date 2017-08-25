package com.mapper.selma;

import com.mapper.model.input.Valuation;
import com.mapper.model.output.OutputValuation;
import fr.xebia.extras.selma.Mapper;

/**
 * Created by yangliu on 25/08/2017.
 */
@Mapper
public interface SelmaMapper {
    OutputValuation asValuation(Valuation valuation);
}
