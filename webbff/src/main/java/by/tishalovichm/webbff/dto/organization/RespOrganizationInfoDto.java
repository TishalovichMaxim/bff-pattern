package by.tishalovichm.webbff.dto.organization;

import by.tishalovichm.webbff.dto.department.RespDepartmentDto;

import java.time.LocalDateTime;
import java.util.Map;

public record RespOrganizationInfoDto(
        Long id,
        String name,
        String description,
        String code,
        LocalDateTime creationDate,
        Map<Long, RespDepartmentDto> departments) {
}
