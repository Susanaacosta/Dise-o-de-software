package com.itm.festivos.infra.repository;

import com.itm.festivos.infra.entity.CountryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<CountryEntity, Long> {}
