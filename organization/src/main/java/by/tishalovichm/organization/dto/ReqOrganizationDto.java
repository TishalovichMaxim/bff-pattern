package by.tishalovichm.organization.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(
        description = "Request organization dto model information"
)
@Data
@AllArgsConstructor
public class ReqOrganizationDto {

    private Long id;

    @Schema(
            description = "Name of the organization"
    )
    @NotBlank
    private String name;

    @Schema(
            description = "Description of the organization"
    )
    private String description;

    @Schema(
            description = "Code of the organization"
    )
    @NotBlank
    private String code;

    @Schema(
            description = "Creation date of the organization"
    )
    private LocalDateTime creationDate;

}
