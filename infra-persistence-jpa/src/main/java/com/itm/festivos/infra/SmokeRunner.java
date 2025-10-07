package com.itm.festivos.infra;

import com.itm.festivos.infra.entity.CountryEntity;
import com.itm.festivos.infra.entity.HolidayBaseEntity;
import com.itm.festivos.infra.spring.CountryJpaRepository;
import com.itm.festivos.infra.spring.HolidayBaseJpaRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.itm.festivos.infra")
@EnableJpaRepositories(basePackages = "com.itm.festivos.infra.spring")
public class SmokeRunner implements CommandLineRunner {

  private final CountryJpaRepository countryRepo;
  private final HolidayBaseJpaRepository baseRepo;

  public SmokeRunner(CountryJpaRepository countryRepo, HolidayBaseJpaRepository baseRepo) {
    this.countryRepo = countryRepo;
    this.baseRepo = baseRepo;
  }

  public static void main(String[] args) {
    SpringApplication.run(SmokeRunner.class, args);
  }

  @Override
  public void run(String... args) {
    CountryEntity co = new CountryEntity();
    co.setName("Colombia"); co.setCode("CO");
    co = countryRepo.save(co);

    HolidayBaseEntity hb = new HolidayBaseEntity();
    hb.setCountryId(co.getId());
    hb.setName("Dia del Trabajo");
    hb.setTypeId(1L);
    hb.setMonth(5); hb.setDay(1);
    baseRepo.save(hb);

    System.out.println("Pais: " +
        countryRepo.findByCode("CO").map(CountryEntity::getName).orElse("N/A"));
    System.out.println("# Festivos del pais: " +
        baseRepo.findByCountryId(co.getId()).size());

    System.exit(0);
  }
}
