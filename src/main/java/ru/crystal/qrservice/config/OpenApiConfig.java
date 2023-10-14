package ru.crystal.qrservice.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @project QRService
 * ©Crystal2033
 * @date 14/10/2023
 */
@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI usersMicroserviceOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("Сервис менеджера QR кодов")
                        .description("Менеджер компонентов по работе объектов с QR-кодами")
                        .version("1.0"));
    }
}
