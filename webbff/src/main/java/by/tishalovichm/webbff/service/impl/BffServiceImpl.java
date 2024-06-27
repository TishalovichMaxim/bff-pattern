package by.tishalovichm.webbff.service.impl;

import by.tishalovichm.webbff.dto.department.ApiDepartmentDto;
import by.tishalovichm.webbff.dto.department.RespDepartmentDto;
import by.tishalovichm.webbff.dto.organization.ApiOrganizationDto;
import by.tishalovichm.webbff.dto.organization.RespOrganizationInfoDto;
import by.tishalovichm.webbff.exception.ApiException;
import by.tishalovichm.webbff.exception.ResourceNotFoundException;
import by.tishalovichm.webbff.mapper.DepartmentMapper;
import by.tishalovichm.webbff.mapper.OrganizationInfoMapper;
import by.tishalovichm.webbff.service.BffService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
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

    private Map<Long, RespDepartmentDto> getRespDepartments(
            ApiDepartmentDto[] departmentDtos) {

        Map<Long, RespDepartmentDto> respDepartments = new HashMap<>();
        for (ApiDepartmentDto departmentDto : departmentDtos) {
            respDepartments.put(departmentDto.getId(),
                    departmentMapper.toDto(departmentDto));
        }

        return respDepartments;
    }

    private Mono<ApiDepartmentDto[]> getDepartments(Long organizationId) {
        String uri = "http://localhost:8080/api/v1/departments?organization-id={id}";

        return webClient
                .get()
                .uri(uri, organizationId)
                .retrieve()
                .onStatus(
                        httpStatus -> httpStatus.equals(
                                HttpStatus.INTERNAL_SERVER_ERROR),
                        resp -> Mono.error(
                                new ApiException("Something was wrong",
                                        HttpStatus.INTERNAL_SERVER_ERROR)))
                .bodyToMono(ApiDepartmentDto[].class);
    }

    private Mono<ApiOrganizationDto> getOrganization(
            Long organizationId, String authToken) {

        return webClient
                .get()
                .uri("http://localhost:8082/api/v1/organizations/{id}",
                        organizationId)
                .header("Authorization", authToken)
                .retrieve()
                .onStatus(
                        httpStatus -> httpStatus.equals(
                                HttpStatus.INTERNAL_SERVER_ERROR),
                        resp -> Mono.error(
                                new ApiException("Something was wrong",
                                        HttpStatus.INTERNAL_SERVER_ERROR)))
                .onStatus(
                        httpStatus -> httpStatus.equals(HttpStatus.NOT_FOUND),
                        resp -> Mono.error(
                                new ResourceNotFoundException(organizationId)))
                .onStatus(
                        httpStatus -> httpStatus.equals(HttpStatus.UNAUTHORIZED),
                        resp -> Mono.error(
                                new ApiException("Unauthorized (organization)",
                                        HttpStatus.UNAUTHORIZED)))
                .onStatus(
                        httpStatus -> httpStatus.equals(HttpStatus.FORBIDDEN),
                        resp -> Mono.error(
                                new ApiException("Forbidden (organization)",
                                        HttpStatus.FORBIDDEN)))
                .bodyToMono(ApiOrganizationDto.class);
    }

    public RespOrganizationInfoDto getOrganizationInfo(Long organizationId,
                                                       String authToken) {

        Mono<ApiOrganizationDto> organizationMono = getOrganization(organizationId,
                authToken);

        Mono<ApiDepartmentDto[]> departmentDtosMono = getDepartments(organizationId);

        return Mono.zip(organizationMono, departmentDtosMono,
                (organization, departments) -> organizationInfoMapper.toRespInfo(
                        organization,
                        getRespDepartments(departments)
                )
        ).block();
    }

}
