package com.itm.festivos.api.controller;

import com.itm.festivos.api.dto.CountryDto;
import com.itm.festivos.api.service.CountryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "Countries")
@RestController
@RequestMapping("/api/countries")
public class CountryController {
  private final CountryService service;

  public CountryController(CountryService service) {
    this.service = service;
  }

  @Operation(summary = "Listar países")
  @GetMapping
  public List<CountryDto> list() {
    return service.list();
  }
}
