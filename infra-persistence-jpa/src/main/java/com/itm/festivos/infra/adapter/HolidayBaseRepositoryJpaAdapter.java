package com.itm.festivos.infra.adapter;

import com.itm.festivos.domain.model.HolidayBase;
import com.itm.festivos.domain.port.HolidayBaseRepository;
import com.itm.festivos.infra.entity.HolidayBaseEntity;
import com.itm.festivos.infra.spring.CountryJpaRepository;
import com.itm.festivos.infra.spring.HolidayBaseJpaRepository;

import java.util.List;
import java.util.stream.Collectors;

public class HolidayBaseRepositoryJpaAdapter implements HolidayBaseRepository {

    private final HolidayBaseJpaRepository repo;
    private final CountryJpaRepository countryRepo;

    public HolidayBaseRepositoryJpaAdapter(HolidayBaseJpaRepository repo, CountryJpaRepository countryRepo) {
        this.repo = repo;
        this.countryRepo = countryRepo;
    }

    @Override
    public List<HolidayBase> findByCountryId(Long countryId) {
        return map(repo.findByCountryId(countryId));
    }

    @Override
    public List<HolidayBase> findByCountryCode(String countryCode) {
        return countryRepo.findByCode(countryCode)
                .map(c -> repo.findByCountryId(c.getId()))
                .map(this::map)
                .orElseGet(List::of);
    }

    @Override
    public List<HolidayBase> findFixedByCountryId(Long countryId) {
        return map(repo.findByCountryIdAndMonthIsNotNull(countryId));
    }

    @Override
    public List<HolidayBase> findEasterBasedByCountryId(Long countryId) {
        return map(repo.findByCountryIdAndDaysFromEasterIsNotNull(countryId));
    }

    /* Helpers*/

    private List<HolidayBase> map(List<HolidayBaseEntity> list) {
        return list.stream().map(this::toDomain).collect(Collectors.toList());
    }

    private HolidayBase toDomain(HolidayBaseEntity e) {
        if (e.getDaysFromEaster() != null) {
            return HolidayBase.easterOffset(
                    e.getId(),
                    e.getCountryId(),
                    e.getName(),
                    e.getTypeId(),
                    e.getDaysFromEaster()
            );
        }
        int m = e.getMonth() == null ? 0 : e.getMonth();
        int d = e.getDay() == null ? 0 : e.getDay();
        return HolidayBase.fixed(
                e.getId(),
                e.getCountryId(),
                e.getName(),
                e.getTypeId(),
                m, d
        );
    }
}
