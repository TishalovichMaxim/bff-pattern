package by.tishalovichm.mobilebff.mapper;

import by.tishalovichm.mobilebff.dto.department.RespDepartmentDto;
import by.tishalovichm.mobilebff.dto.organization.ApiOrganizationDto;
import by.tishalovichm.mobilebff.dto.organization.RespOrganizationInfoDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface OrganizationInfoMapper {

    RespOrganizationInfoDto toRespInfo(ApiOrganizationDto organization,
                                       List<RespDepartmentDto> departments);

}
