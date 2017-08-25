package com.mapper.selma;

import com.mapper.model.input.Valuation;
import com.mapper.model.output.OutputValuation;
import fr.xebia.extras.selma.Field;
import fr.xebia.extras.selma.IgnoreMissing;
import fr.xebia.extras.selma.Mapper;

/**
 * Created by yangliu on 25/08/2017.
 */
@Mapper(withIgnoreFields = {"property", "risks", "contacts"},
        withIgnoreMissing = IgnoreMissing.SOURCE,
        withCustomFields = {
                @Field({"supplier", "supplierCode"})
        },
        withCustom = {
                LocalDateCustomMapper.class,
                BooleanCustomMapper.class
        }
)
public interface SelmaMapper {
    OutputValuation asValuation(Valuation valuation);
}
