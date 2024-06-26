package by.tishalovichm.organization;

import by.tishalovichm.organization.mapper.OrganizationMapper;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.mapstruct.factory.Mappers;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@OpenAPIDefinition(
        info = @Info(
                title = "Organization REST API",
                description = "Organization REST API documentation",
                version = "v1.0",
                contact = @Contact(
                        name = "Tishalovich Maxim",
                        email = "tishalovichm@gmail.com",
                        url = "https://github.com/TishalovichMaxim"
                ),
                license = @License(
                        name = "MIT"
                )
        ),
        externalDocs = @ExternalDocumentation(
                description = "You can get info by contact me",
                url = "https://github.com/TishalovichMaxim"
        )
)
@SpringBootApplication
public class OrganizationApplication {

    @Bean
    public OrganizationMapper organizationMapper() {
        return Mappers.getMapper(OrganizationMapper.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(OrganizationApplication.class, args);
    }

}
