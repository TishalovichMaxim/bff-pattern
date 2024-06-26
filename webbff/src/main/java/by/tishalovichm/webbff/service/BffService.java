package by.tishalovichm.webbff.service;

import by.tishalovichm.webbff.dto.organization.RespOrganizationInfoDto;

public interface BffService {

    RespOrganizationInfoDto getOrganizationInfo(Long organizationId);

}
