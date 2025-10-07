package com.itm.festivos.infra.adapter;

import com.itm.festivos.domain.model.Country;
import com.itm.festivos.domain.port.CountryRepository;
import com.itm.festivos.infra.entity.CountryEntity;
import com.itm.festivos.infra.spring.CountryJpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CountryRepositoryJpaAdapter implements CountryRepository {

    private final CountryJpaRepository repo;

    public CountryRepositoryJpaAdapter(CountryJpaRepository repo) {
        this.repo = repo;
    }

    @Override
    public Optional<Country> findById(Long id) {
        return repo.findById(id).map(this::toDomain);
    }

    @Override
    public Optional<Country> findByCode(String code) {
        return repo.findByCode(code).map(this::toDomain);
    }

    @Override
    public List<Country> findAll() {
        return repo.findAll().stream().map(this::toDomain).collect(Collectors.toList());
    }

    private Country toDomain(CountryEntity e) {
        return new Country(e.getId(), e.getName(), e.getCode());
    }
}
