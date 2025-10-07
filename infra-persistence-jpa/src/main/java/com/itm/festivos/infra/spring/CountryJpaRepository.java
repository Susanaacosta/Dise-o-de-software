package com.itm.festivos.infra.spring;

import com.itm.festivos.infra.entity.CountryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CountryJpaRepository extends JpaRepository<CountryEntity, Long> {
    Optional<CountryEntity> findByCode(String code);
}
