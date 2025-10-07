package com.itm.festivos.infra.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "country")
public class CountryEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "name", nullable = false, length = 80)
  private String name;

  @Column(name = "code", nullable = false, unique = true, length = 5)
  private String code;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }
}
