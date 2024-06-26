package by.tishalovichm.mobilebff.dto.organization;

import by.tishalovichm.mobilebff.dto.department.RespDepartmentDto;

import java.time.LocalDateTime;
import java.util.List;

public record RespOrganizationInfoDto(
        Long id,
        String name,
        String description,
        String code,
        LocalDateTime creationDate,
        List<RespDepartmentDto> departments) {
}
