package com.itm.festivos.infra;

import com.itm.festivos.infra.entity.CountryEntity;
import com.itm.festivos.infra.entity.HolidayBaseEntity;
import com.itm.festivos.infra.spring.CountryJpaRepository;
import com.itm.festivos.infra.spring.HolidayBaseJpaRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("smoke")
public class SmokeRunner implements CommandLineRunner {

  private final CountryJpaRepository countryRepo;
  private final HolidayBaseJpaRepository baseRepo;

  public SmokeRunner(CountryJpaRepository countryRepo, HolidayBaseJpaRepository baseRepo) {
    this.countryRepo = countryRepo;
    this.baseRepo = baseRepo;
  }

  @Override
  public void run(String... args) {
    CountryEntity co = new CountryEntity();
    co.setName("Colombia");
    co.setCode("CO");
    co = countryRepo.save(co);

    HolidayBaseEntity hb = new HolidayBaseEntity();
    hb.setCountryId(co.getId());
    hb.setName("Dia del Trabajo");
    hb.setTypeId(1L);
    hb.setMonth(5);
    hb.setDay(1);
    baseRepo.save(hb);

    System.out.println("Pais: " +
        countryRepo.findByCode("CO").map(CountryEntity::getName).orElse("N/A"));
    System.out.println("# Festivos del pais: " +
        baseRepo.findByCountryId(co.getId()).size());

    // Importante: NO hagas System.exit(0) aquí para no tumbar el server.
  }
}
