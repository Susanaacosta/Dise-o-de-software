package com.itm.festivos.api.mapper;

import com.itm.festivos.api.dto.CountryDto;
import com.itm.festivos.api.dto.HolidayDto;
import com.itm.festivos.infra.entity.CountryEntity;
import com.itm.festivos.infra.entity.HolidayBaseEntity;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Year;

public final class Mappers {
    private Mappers() {}

    public static CountryDto toDto(CountryEntity e) {
    
        return new CountryDto(e.getId(), e.getCode(), e.getName());
    }

    public static HolidayDto toDto(HolidayBaseEntity e) {
     
        LocalDate date = null;
        if (e.getMonth() != null && e.getDay() != null) {
            try {
                date = LocalDate.of(Year.now().getValue(), e.getMonth(), e.getDay());
            } catch (DateTimeException ignored) {
             
            }
        }

        String type = (e.getTypeId() != null) ? String.valueOf(e.getTypeId()) : null;

        return new HolidayDto(e.getId(), e.getName(), date, type);
    }
}
