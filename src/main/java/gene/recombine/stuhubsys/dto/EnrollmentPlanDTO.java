package gene.recombine.stuhubsys.dto;

import gene.recombine.stuhubsys.entity.EnrollmentPlan;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class EnrollmentPlanDTO extends EnrollmentPlan {
    @Schema(description = "当前页码", example = "1")
    private int pageNo;
    @Schema(description = "分页大小", example = "10")
    private int pageSize;
}
