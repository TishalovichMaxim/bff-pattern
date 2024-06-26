package by.tishalovichm.mobilebff.service;

import by.tishalovichm.mobilebff.dto.organization.RespOrganizationInfoDto;

public interface BffService {

    RespOrganizationInfoDto getOrganizationInfo(Long organizationId);

}
