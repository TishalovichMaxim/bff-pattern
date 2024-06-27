package by.tishalovichm.webbff.controller;

import by.tishalovichm.webbff.dto.organization.RespOrganizationInfoDto;
import by.tishalovichm.webbff.service.BffService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/organizations")
@RequiredArgsConstructor
public class BffController {

    private final BffService service;

    @GetMapping("{id}")
    public ResponseEntity<RespOrganizationInfoDto> findById(
            @PathVariable Long id,
            @RequestHeader(name = "Authorization", required = false) String token) {

        return ResponseEntity.ok(service.getOrganizationInfo(id, token));
    }

}
