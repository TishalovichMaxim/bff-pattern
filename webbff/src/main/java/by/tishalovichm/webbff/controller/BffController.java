package by.tishalovichm.webbff.controller;

import by.tishalovichm.webbff.dto.organization.RespOrganizationInfoDto;
import by.tishalovichm.webbff.service.BffService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/organizations")
@RequiredArgsConstructor
public class BffController {

    private final BffService service;

    @GetMapping("{id}")
    public ResponseEntity<RespOrganizationInfoDto> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getOrganizationInfo(id));
    }

}
