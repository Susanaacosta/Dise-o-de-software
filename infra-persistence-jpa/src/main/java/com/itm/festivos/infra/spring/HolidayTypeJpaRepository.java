package com.itm.festivos.infra.spring;

import com.itm.festivos.infra.entity.HolidayTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HolidayTypeJpaRepository extends JpaRepository<HolidayTypeEntity, Long> {
}
