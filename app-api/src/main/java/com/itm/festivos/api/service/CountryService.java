package com.itm.festivos.api.service;

import com.itm.festivos.api.dto.CountryDto;
import com.itm.festivos.api.mapper.Mappers;
import com.itm.festivos.infra.repository.CountryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {
  private final CountryRepository repo;

  public CountryService(CountryRepository repo) {
    this.repo = repo;
  }

  public List<CountryDto> list() {
    return repo.findAll().stream().map(Mappers::toDto).toList();
  }
}
