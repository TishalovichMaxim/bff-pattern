package by.tishalovichm.department.mapper;

import by.tishalovichm.department.dto.ReqDepartmentDto;
import by.tishalovichm.department.dto.RespDepartmentDto;
import by.tishalovichm.department.entity.Department;
import org.mapstruct.Mapper;

@Mapper
public interface DepartmentMapper {

    Department reqToEntity(ReqDepartmentDto dto);

    RespDepartmentDto entityToResp(Department department);

}
