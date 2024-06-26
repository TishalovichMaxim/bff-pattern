package by.tishalovichm.mobilebff;

import by.tishalovichm.mobilebff.mapper.DepartmentMapper;
import by.tishalovichm.mobilebff.mapper.OrganizationInfoMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class MobilebffApplication {

	@Bean
	public WebClient webClient() {
		return WebClient.create();
	}

	@Bean
	public DepartmentMapper departmentMapper() {
		return Mappers.getMapper(DepartmentMapper.class);
	}

	@Bean
	public OrganizationInfoMapper organizationInfoMapper() {
		return Mappers.getMapper(OrganizationInfoMapper.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(MobilebffApplication.class, args);
	}

}
