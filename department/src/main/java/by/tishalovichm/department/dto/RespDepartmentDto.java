package by.tishalovichm.department.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Schema(
        description = "Response department dto model information"
)
@Data
@AllArgsConstructor
public class RespDepartmentDto {

    private Long id;

    @NotNull
    private Long organizationId;

    @Schema(
            description = "Department name"
    )
    private String departmentName;

    @Schema(
            description = "Department description"
    )
    private String departmentDescription;

    @Schema(
            description = "Department code"
    )
    private String departmentCode;

}
