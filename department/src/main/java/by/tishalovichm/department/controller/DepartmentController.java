package by.tishalovichm.department.controller;

import by.tishalovichm.department.dto.ReqDepartmentDto;
import by.tishalovichm.department.dto.RespDepartmentDto;
import by.tishalovichm.department.service.DepartmentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(
        name = "Department Controller",
        description = "Department controller exposes REST APIs for Department-Service"
)
@RestController
@RequestMapping("v1/departments")
@RequiredArgsConstructor
public class DepartmentController {

    private final DepartmentService service;

    @Operation(
            summary = "Get department by id",
            description = "Used to retrieve department from db by id"
    )
    @ApiResponses(
            @ApiResponse(
                    responseCode = "200",
                    description = "Department found"
            )
    )
    @GetMapping("{id}")
    public ResponseEntity<RespDepartmentDto> get(@PathVariable Long id) {
        return new ResponseEntity<>(
                service.get(id),
                HttpStatus.OK
        );
    }

    @Operation(
            summary = "Get department by department code",
            description = "Used to get retrieve department from db by code"
    )
    @ApiResponses(
            @ApiResponse(
                    responseCode = "200",
                    description = "Department found"
            )
    )
    @GetMapping("")
    public ResponseEntity<RespDepartmentDto> get(
            @RequestParam("department-code") String departmentCode) {

        return new ResponseEntity<>(
                service.get(departmentCode),
                HttpStatus.OK
        );
    }

    @Operation(
            summary = "Create new department",
            description = "Used to save new department to a database"
    )
    @ApiResponses(
            @ApiResponse(
                    responseCode = "201",
                    description = "Department created"
            )
    )
    @PostMapping("")
    public ResponseEntity<RespDepartmentDto> save(
            @RequestBody @Valid ReqDepartmentDto reqDepartmentDto) {

        return new ResponseEntity<>(
                service.save(reqDepartmentDto),
                HttpStatus.CREATED
        );
    }

}
