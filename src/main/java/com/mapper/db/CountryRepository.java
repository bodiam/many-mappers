package com.mapper.db;

public class CountryRepository {
    public static String getCountryByIso3(String iso3) {
        switch (iso3) {
            case "AUS":
                return "Australia";
            case "NLD":
                return "The Netherlands";
            default:
                throw new IllegalArgumentException("Couldn't map " + iso3 + " country code");
        }
    }
}
