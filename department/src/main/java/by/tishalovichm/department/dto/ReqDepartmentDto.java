package by.tishalovichm.department.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Schema(
        description = "Request department dto model information"
)
@Data
@AllArgsConstructor
public class ReqDepartmentDto {

    private Long id;

    @Schema(
            description = "Department name"
    )
    @NotBlank
    private String departmentName;

    @Schema(
            description = "Department description"
    )
    @NotNull
    @Length(min = 6)
    private String departmentDescription;

    @Schema(
            description = "Department code"
    )
    @NotBlank
    private String departmentCode;

}
