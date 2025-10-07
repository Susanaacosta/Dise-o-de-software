package com.itm.festivos.infra.spring;

import com.itm.festivos.infra.entity.HolidayBaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HolidayBaseJpaRepository extends JpaRepository<HolidayBaseEntity, Long> {
    List<HolidayBaseEntity> findByCountryId(Long countryId);
    List<HolidayBaseEntity> findByCountryIdAndMonthIsNotNull(Long countryId);
    List<HolidayBaseEntity> findByCountryIdAndDaysFromEasterIsNotNull(Long countryId);
}
