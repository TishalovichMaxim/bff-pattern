package by.tishalovichm.mobilebff.dto.department;

public record RespDepartmentDto(
        Long id,
        Long organizationId,
        String departmentName,
        String departmentDescription,
        String departmentCode) {
}
