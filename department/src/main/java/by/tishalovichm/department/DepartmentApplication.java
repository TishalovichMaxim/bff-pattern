package by.tishalovichm.department;

import by.tishalovichm.department.mapper.DepartmentMapper;
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
                title = "Department REST API",
                description = "Department REST API documentation",
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
public class DepartmentApplication {

    @Bean
    public DepartmentMapper mapper() {
        return Mappers.getMapper(DepartmentMapper.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(DepartmentApplication.class, args);
    }

}
