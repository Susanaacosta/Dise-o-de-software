package com.itm.festivos.domain.model;

public final class HolidayType {
  private final Long id;
  private final String name;
  private final HolidayMode mode;

  public HolidayType(Long id, String name, HolidayMode mode) {
    this.id = id;
    this.name = name;
    this.mode = mode;
  }

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public HolidayMode getMode() {
    return mode;
  }
}
