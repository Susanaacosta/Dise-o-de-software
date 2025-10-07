package com.itm.festivos.infra.adapter;

import com.itm.festivos.domain.model.HolidayType;
import com.itm.festivos.domain.port.HolidayTypeRepository;
import com.itm.festivos.infra.entity.HolidayTypeEntity;
import com.itm.festivos.infra.spring.HolidayTypeJpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class HolidayTypeRepositoryJpaAdapter implements HolidayTypeRepository {

    private final HolidayTypeJpaRepository repo;

    public HolidayTypeRepositoryJpaAdapter(HolidayTypeJpaRepository repo) {
        this.repo = repo;
    }

    @Override
    public Optional<HolidayType> findById(Long id) {
        return repo.findById(id).map(this::toDomain);
    }

    @Override
    public List<HolidayType> findAll() {
        return repo.findAll().stream().map(this::toDomain).collect(Collectors.toList());
    }

    private HolidayType toDomain(HolidayTypeEntity e) {
        return new HolidayType(e.getId(), e.getName(), e.getMode());
    }
}
