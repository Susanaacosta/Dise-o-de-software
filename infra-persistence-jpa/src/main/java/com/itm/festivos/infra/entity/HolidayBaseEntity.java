package com.itm.festivos.infra.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "holiday_base")   // nombre de tabla claro evita keywords
public class HolidayBaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "country_id", nullable = false)
  private Long countryId;

  @Column(name = "name", nullable = false, length = 120)
  private String name;

  @Column(name = "type_id", nullable = false)
  private Long typeId;

  // Evitar keywords en H2 y  renombramos nombres de columna
  @Column(name = "month_value")
  private Integer month;

  @Column(name = "day_value")
  private Integer day;

  @Column(name = "days_from_easter")
  private Integer daysFromEaster;

  /* getters*/
  public Long getId() { return id; }
  public Long getCountryId() { return countryId; }
  public String getName() { return name; }
  public Long getTypeId() { return typeId; }
  public Integer getMonth() { return month; }
  public Integer getDay() { return day; }
  public Integer getDaysFromEaster() { return daysFromEaster; }

  /* setters */
  public void setId(Long id) { this.id = id; }
  public void setCountryId(Long countryId) { this.countryId = countryId; }
  public void setName(String name) { this.name = name; }
  public void setTypeId(Long typeId) { this.typeId = typeId; }
  public void setMonth(Integer month) { this.month = month; }
  public void setDay(Integer day) { this.day = day; }
  public void setDaysFromEaster(Integer daysFromEaster) { this.daysFromEaster = daysFromEaster; }
}
