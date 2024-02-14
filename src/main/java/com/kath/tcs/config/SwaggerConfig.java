package com.kath.tcs.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI apiInfo() {
        Contact contact = new Contact();
        contact.setEmail("nepal.hrishikesh@gmail.com");
        contact.setName("Hrishikesh Nepal");
        License serviceLicense = new License().name("no license");
        Info info = new Info()
                .title("traffic-control-system")
                .version("1.0.0")
                .contact(contact)
                .description("Traffic control system service")
                .license(serviceLicense);

        return new OpenAPI()
                .info(info)
                .externalDocs(new ExternalDocumentation()
                        .description("SpringShop Wiki Documentation")
                        .url("https://springshop.wiki.github.org/docs"));
    }
}
