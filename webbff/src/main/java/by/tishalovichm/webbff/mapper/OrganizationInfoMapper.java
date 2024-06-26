package by.tishalovichm.webbff.mapper;

import by.tishalovichm.webbff.dto.department.RespDepartmentDto;
import by.tishalovichm.webbff.dto.organization.ApiOrganizationDto;
import by.tishalovichm.webbff.dto.organization.RespOrganizationInfoDto;
import org.mapstruct.Mapper;

import java.util.Map;

@Mapper
public interface OrganizationInfoMapper {

    RespOrganizationInfoDto toRespInfo(ApiOrganizationDto organization,
                                       Map<Long, RespDepartmentDto> departments);

}
