package com.farmacia.farmacia.shared.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI farmaciaApi() {
        return new OpenAPI()
                .info(new Info()
                        .title("API – Sistema de Farmaciav")
                        .description("Documentación interactiva de los endpoints del sistema de farmacia.")
                        .version("1.0.0"));
    }
}
