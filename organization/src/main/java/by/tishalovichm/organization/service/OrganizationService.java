package by.tishalovichm.organization.service;

import by.tishalovichm.organization.dto.ReqOrganizationDto;
import by.tishalovichm.organization.dto.RespOrganizationDto;

public interface OrganizationService {

    RespOrganizationDto save(ReqOrganizationDto dto);

    RespOrganizationDto get(Long id);

    RespOrganizationDto get(String code);

}
