package by.tishalovichm.organization.service.impl;

import by.tishalovichm.organization.dto.ReqOrganizationDto;
import by.tishalovichm.organization.exception.ApiException;
import by.tishalovichm.organization.dto.RespOrganizationDto;
import by.tishalovichm.organization.entity.Organization;
import by.tishalovichm.organization.exception.ResourceNotFoundException;
import by.tishalovichm.organization.mapper.OrganizationMapper;
import by.tishalovichm.organization.repository.OrganizationRepository;
import by.tishalovichm.organization.service.OrganizationService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrganizationServiceImpl implements OrganizationService {

    private final OrganizationMapper mapper;

    private final OrganizationRepository repository;

    @SneakyThrows
    @Override
    public RespOrganizationDto save(ReqOrganizationDto reqOrganizationDto) {
        Organization organization = mapper.reqToEntity(reqOrganizationDto);

        try {
            Organization savedOrganization = repository.save(organization);
            return mapper.entityToResp(savedOrganization);
        } catch (DataIntegrityViolationException e) {
            throw new ApiException("Organization code must be unique");
        }
    }

    @SneakyThrows
    @Override
    public RespOrganizationDto get(Long id) {
        Organization organization = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException(id)
        );

        return mapper.entityToResp(organization);
    }

    @SneakyThrows
    @Override
    public RespOrganizationDto get(String code) {
        Organization organization = repository.findByCode(code).orElseThrow(
                () -> new ResourceNotFoundException("organization code", code)
        );

        return mapper.entityToResp(organization);
    }

}
