package com.cinema.cinema.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI openApiProjectConfig () {
        return new OpenAPI()
                .info(new Info()
                        .title("Проект для аттестации")
                        .description("Сервис онлайн-кинотеатра")
                        .version("1.0")
                        .license(new License().name("Apache Free Licence 2.0"))
                        .contact(new Contact().name("E.Martyona")
                                .email("support@bk.ru"))
                );
    }
}
