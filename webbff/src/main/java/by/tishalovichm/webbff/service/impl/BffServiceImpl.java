package by.tishalovichm.webbff.service.impl;

import by.tishalovichm.webbff.dto.department.ApiDepartmentDto;
import by.tishalovichm.webbff.dto.department.RespDepartmentDto;
import by.tishalovichm.webbff.dto.organization.ApiOrganizationDto;
import by.tishalovichm.webbff.dto.organization.RespOrganizationInfoDto;
import by.tishalovichm.webbff.mapper.DepartmentMapper;
import by.tishalovichm.webbff.mapper.OrganizationInfoMapper;
import by.tishalovichm.webbff.service.BffService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

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

        Map<Long, RespDepartmentDto> respDepartments = new HashMap<>();
        for (ApiDepartmentDto departmentDto : departments) {
            respDepartments.put(departmentDto.getId(),
                    departmentMapper.toDto(departmentDto));
        }

        return organizationInfoMapper.toRespInfo(
                organization,
                respDepartments
        );
    }

}
