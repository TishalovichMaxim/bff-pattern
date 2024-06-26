package by.tishalovichm.department.service.impl;

import by.tishalovichm.department.dal.DepartmentRepository;
import by.tishalovichm.department.dto.ReqDepartmentDto;
import by.tishalovichm.department.dto.RespDepartmentDto;
import by.tishalovichm.department.entity.Department;
import by.tishalovichm.department.exception.ApiException;
import by.tishalovichm.department.exception.ResourceNotFoundException;
import by.tishalovichm.department.mapper.DepartmentMapper;
import by.tishalovichm.department.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentMapper mapper;

    private final DepartmentRepository repository;

    @Override
    @SneakyThrows
    public RespDepartmentDto save(ReqDepartmentDto dto) {
        Department department = mapper.reqToEntity(dto);

        try {
            Department savedDepartment = repository.save(department);
            return mapper.entityToResp(savedDepartment);
        } catch (DataIntegrityViolationException e) {
            throw new ApiException("Department code must be unique");
        }
    }

    @Override
    @SneakyThrows
    public RespDepartmentDto get(Long id) {
        Department department = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));

        return mapper.entityToResp(department);
    }

    @Override
    @SneakyThrows
    public RespDepartmentDto get(String departmentCode) {
        Department department = repository.findByDepartmentCode(departmentCode)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "departmentCode", departmentCode));

        return mapper.entityToResp(department);
    }

}
