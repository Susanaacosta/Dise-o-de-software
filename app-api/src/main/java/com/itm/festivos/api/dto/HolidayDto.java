package com.itm.festivos.api.dto;

import java.time.LocalDate;

public record HolidayDto(Long id, String name, LocalDate date, String type) {}
