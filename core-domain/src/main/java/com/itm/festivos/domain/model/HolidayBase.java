package com.itm.festivos.domain.model;

import java.util.Optional;

public final class HolidayBase {
  private final Long id, countryId, typeId;
  private final String name;
  private final Integer month, day, daysFromEaster;

  private HolidayBase(Long id, Long countryId, String name, Long typeId, Integer month, Integer day,
      Integer daysFromEaster) {
    this.id = id;
    this.countryId = countryId;
    this.name = name;
    this.typeId = typeId;
    this.month = month;
    this.day = day;
    this.daysFromEaster = daysFromEaster;
  }

  public static HolidayBase fixed(Long id, Long countryId, String name, Long typeId, int month, int day) {
    return new HolidayBase(id, countryId, name, typeId, month, day, null);
  }

  public static HolidayBase easterOffset(Long id, Long countryId, String name, Long typeId, int offset) {
    return new HolidayBase(id, countryId, name, typeId, null, null, offset);
  }

  public Long getId() {
    return id;
  }

  public Long getCountryId() {
    return countryId;
  }

  public String getName() {
    return name;
  }

  public Long getTypeId() {
    return typeId;
  }

  public Optional<Integer> getMonth() {
    return Optional.ofNullable(month);
  }

  public Optional<Integer> getDay() {
    return Optional.ofNullable(day);
  }

  public Optional<Integer> getDaysFromEaster() {
    return Optional.ofNullable(daysFromEaster);
  }
}
