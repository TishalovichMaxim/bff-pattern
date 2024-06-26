package by.tishalovichm.mobilebff.dto.organization;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ApiOrganizationDto {

    private Long id;

    private String name;

    private String description;

    private String code;

    private LocalDateTime creationDate;

}
