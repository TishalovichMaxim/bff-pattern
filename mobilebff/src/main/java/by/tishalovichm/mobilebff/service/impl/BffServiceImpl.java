package by.tishalovichm.mobilebff.service.impl;

import by.tishalovichm.mobilebff.dto.department.ApiDepartmentDto;
import by.tishalovichm.mobilebff.dto.organization.ApiOrganizationDto;
import by.tishalovichm.mobilebff.dto.organization.RespOrganizationInfoDto;
import by.tishalovichm.mobilebff.mapper.DepartmentMapper;
import by.tishalovichm.mobilebff.mapper.OrganizationInfoMapper;
import by.tishalovichm.mobilebff.service.BffService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Arrays;

@Service
@RequiredArgsConstructor
public class BffServiceImpl implements BffService {

    private final WebClient webClient;

    private final DepartmentMapper departmentMapper;

    private final OrganizationInfoMapper organizationInfoMapper;

    private Mono<ApiDepartmentDto[]> getDepartments(Long organizationId) {
        String queryParam = String.join("=", "organization-id",
                organizationId.toString());

        return webClient
                .get()
                .uri(String.join("?",
                                "http://localhost:8080/api/v1/departments",
                                queryParam))
                .retrieve()
                .bodyToMono(ApiDepartmentDto[].class);
    }

    private Mono<ApiOrganizationDto> getOrganization(Long organizationId) {
        return webClient
                .get()
                .uri(String.join(
                        "/",
                        "http://localhost:8082/api/v1/organizations",
                        organizationId.toString()))
                .retrieve()
                .bodyToMono(ApiOrganizationDto.class);
    }

    public RespOrganizationInfoDto getOrganizationInfo(Long organizationId) {
        Mono<ApiOrganizationDto> organizationMono = getOrganization(organizationId);
        Mono<ApiDepartmentDto[]> departmentDtosMono = getDepartments(organizationId);

        ApiOrganizationDto organization = organizationMono.block();
        ApiDepartmentDto[] departments = departmentDtosMono.block();

        return organizationInfoMapper.toRespInfo(
                organization,
                Arrays.stream(departments).map(departmentMapper::toDto).toList()
        );
    }

}
