package com.mapper.mapstruct;

import com.mapper.db.CountryRepository;
import com.mapper.model.input.Country;

public class Iso3ToFullCountryUtil {

    @Iso3Country
    public String convert(Country country) {
        return CountryRepository.getCountryByIso3(country.name());
    }

}
