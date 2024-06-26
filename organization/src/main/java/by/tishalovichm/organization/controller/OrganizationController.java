package by.tishalovichm.organization.controller;

import by.tishalovichm.organization.dto.ReqOrganizationDto;
import by.tishalovichm.organization.dto.RespOrganizationDto;
import by.tishalovichm.organization.service.OrganizationService;
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
        name = "Organization Controller",
        description = "Organization controller exposes REST APIs for Organization-Service"
)
@RestController
@RequestMapping("v1/organizations")
@RequiredArgsConstructor
public class OrganizationController {

    private final OrganizationService service;

    @Operation(
            summary = "Get organization by id",
            description = "Used to retrieve organization from db by id"
    )
    @ApiResponses(
            @ApiResponse(
                    responseCode = "200",
                    description = "Organization found"
            )
    )
    @GetMapping("{id}")
    public ResponseEntity<RespOrganizationDto> get(@PathVariable Long id) {
        return ResponseEntity.ok(service.get(id));
    }


    @Operation(
            summary = "Get organization by organization code",
            description = "Used to retrieve organization from db by code"
    )
    @ApiResponses(
            @ApiResponse(
                    responseCode = "200",
                    description = "Organization found"
            )
    )
    @GetMapping("")
    public ResponseEntity<RespOrganizationDto> get(@RequestParam String code) {
        return ResponseEntity.ok(service.get(code));
    }

    @Operation(
            summary = "Create new organization",
            description = "Used to save new organization to a database"
    )
    @ApiResponses(
            @ApiResponse(
                    responseCode = "201",
                    description = "Organization created"
            )
    )
    @PostMapping
    public ResponseEntity<RespOrganizationDto> save(
            @RequestBody @Valid ReqOrganizationDto organization) {

        return new ResponseEntity<>(
                service.save(organization),
                HttpStatus.CREATED
        );
    }

}
