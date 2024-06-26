package by.tishalovichm.organization.mapper;

import by.tishalovichm.organization.dto.ReqOrganizationDto;
import by.tishalovichm.organization.dto.RespOrganizationDto;
import by.tishalovichm.organization.entity.Organization;
import org.mapstruct.Mapper;

@Mapper
public interface OrganizationMapper {

    Organization reqToEntity(ReqOrganizationDto dto);

    RespOrganizationDto entityToResp(Organization organization);

}
