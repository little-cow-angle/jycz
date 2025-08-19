package gene.recombine.stuhubsys.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class EnrollmentPlanDTO {
    @Schema(description = "专业名")
    private String majorName;
    @Schema(description = "计划类型")
    private Integer type;
    @Schema(description = "当前页码", example = "1")
    private int pageNo = 1;
    @Schema(description = "分页大小", example = "10")
    private int pageSize = 10;
}
