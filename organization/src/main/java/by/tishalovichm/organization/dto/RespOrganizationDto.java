package by.tishalovichm.organization.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(
        description = "Response organization dto model information"
)
@Data
@AllArgsConstructor
public class RespOrganizationDto {

    private Long id;

    @Schema(
            description = "Name of the organization"
    )
    private String name;

    @Schema(
            description = "Description of the organization"
    )
    private String description;

    @Schema(
            description = "Code of the organization"
    )
    private String code;

    @Schema(
            description = "Creation date of the organization"
    )
    private LocalDateTime creationDate;

}
