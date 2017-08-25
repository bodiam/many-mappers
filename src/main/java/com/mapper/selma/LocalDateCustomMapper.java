package com.mapper.selma;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Created by yangliu on 25/08/2017.
 */
public class LocalDateCustomMapper {
    public LocalDate localDateTimeToLocalDate(LocalDateTime localDateTime) {
        return localDateTime.toLocalDate();
    }
}
