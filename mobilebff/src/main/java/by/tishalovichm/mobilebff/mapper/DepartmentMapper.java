package by.tishalovichm.mobilebff.mapper;

import by.tishalovichm.mobilebff.dto.department.ApiDepartmentDto;
import by.tishalovichm.mobilebff.dto.department.RespDepartmentDto;
import org.mapstruct.Mapper;

@Mapper
public interface DepartmentMapper {

    RespDepartmentDto toDto(ApiDepartmentDto dto);

}
