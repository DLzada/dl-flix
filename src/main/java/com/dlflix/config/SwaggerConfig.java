package com.dlflix.config;

import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI getOpenAPI(){

        Contact contact = new Contact();
        contact.name("Daniel LUiz");
        contact.setUrl("https://github.com/DLzada");

        Info info = new Info();
        info.title("DLFLIX");
        info.version("v1");
        info.description("API para gerenciamento de catalogo de filmes");
        info.contact(contact);

        return new OpenAPI().info(info);
    }
}
