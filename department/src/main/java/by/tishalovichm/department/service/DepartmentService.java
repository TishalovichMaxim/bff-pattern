package by.tishalovichm.department.service;

import by.tishalovichm.department.dto.ReqDepartmentDto;
import by.tishalovichm.department.dto.RespDepartmentDto;

import java.util.List;
import java.util.Optional;

public interface DepartmentService {

    RespDepartmentDto save(ReqDepartmentDto dto);

    RespDepartmentDto get(Long id);

    RespDepartmentDto get(String departmentCode);

    List<RespDepartmentDto> getDepartments();

    List<RespDepartmentDto> getDepartments(Optional<Long> organizationId);

}
