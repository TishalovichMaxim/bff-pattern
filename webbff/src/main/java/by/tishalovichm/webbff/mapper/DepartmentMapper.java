package by.tishalovichm.webbff.mapper;

import by.tishalovichm.webbff.dto.department.ApiDepartmentDto;
import by.tishalovichm.webbff.dto.department.RespDepartmentDto;
import org.mapstruct.Mapper;

@Mapper
public interface DepartmentMapper {

    RespDepartmentDto toDto(ApiDepartmentDto dto);

}
