package by.tishalovichm.department.service;

import by.tishalovichm.department.dto.ReqDepartmentDto;
import by.tishalovichm.department.dto.RespDepartmentDto;

public interface DepartmentService {

    RespDepartmentDto save(ReqDepartmentDto dto);

    RespDepartmentDto get(Long id);

    RespDepartmentDto get(String departmentCode);

}
