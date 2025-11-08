package com.itm.festivos;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI festivosOpenAPI() {
        return new OpenAPI().info(new Info()
            .title("Festivos API")
            .version("v1")
            .description("API para países, tipos de festivo y festivos; valida fechas y lista por año"));
    }
}
