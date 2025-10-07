package com.itm.festivos.infra.entity;

import com.itm.festivos.domain.model.HolidayMode;
import jakarta.persistence.*;

@Entity
@Table(name = "holiday_type")
public class HolidayTypeEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(nullable = false, length = 100)
  private String name;
  @Enumerated(EnumType.STRING)
  @Column(nullable = false, length = 20)
  private HolidayMode mode;

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public HolidayMode getMode() {
    return mode;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setMode(HolidayMode mode) {
    this.mode = mode;
  }
}
