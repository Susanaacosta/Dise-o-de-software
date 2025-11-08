package com.itm.festivos.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.itm.festivos")
@EnableJpaRepositories(basePackages = "com.itm.festivos.infra.repository")
@EntityScan(basePackages = "com.itm.festivos.infra.entity")
public class AppApplication {
      public static void main(String[] args) {
        SpringApplication.run(AppApplication.class, args);
    }
}
