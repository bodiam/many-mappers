package com.mapper.selma;

import com.mapper.model.input.Risk;
import com.mapper.model.output.OutputRisk;
import fr.xebia.extras.selma.Mapper;

import static fr.xebia.extras.selma.CollectionMappingStrategy.ALLOW_GETTER;

/**
 * Created by yangliu on 25/08/2017.
 */
@Mapper(withCollectionStrategy = ALLOW_GETTER)
public interface RiskCollectionMapper {
    OutputRisk asOutputRisk(Risk risk);
}
