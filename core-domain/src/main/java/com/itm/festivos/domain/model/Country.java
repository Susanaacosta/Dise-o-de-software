package com.itm.festivos.domain.model;

import java.util.Objects;

public final class Country {
  private final Long id;
  private final String name;
  private final String code;

  public Country(Long id, String name, String code) {
    this.id = id;
    this.name = name;
    this.code = code;
  }

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getCode() {
    return code;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (!(o instanceof Country))
      return false;
    Country c = (Country) o;
    return Objects.equals(id, c.id) && Objects.equals(code, c.code);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, code);
  }
}
