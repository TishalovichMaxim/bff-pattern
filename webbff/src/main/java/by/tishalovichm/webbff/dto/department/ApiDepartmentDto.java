package by.tishalovichm.webbff.dto.department;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ApiDepartmentDto {

    private Long id;

    private Long organizationId;

    private String departmentName;

    private String departmentDescription;

    private String departmentCode;

}
