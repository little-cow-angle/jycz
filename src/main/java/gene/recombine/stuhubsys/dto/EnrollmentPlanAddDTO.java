package gene.recombine.stuhubsys.dto;

import gene.recombine.stuhubsys.entity.EnrollmentPlan;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * 仅用于文档/请求体描述的 DTO
 * 将新增/查询请求的参数区分开，分别设置required字段
 */
@Schema(name = "EnrollmentPlanAddDTO",
    description = "新增招生计划",
    requiredProperties = { "year", "majorId", "province", "price", "count" } )
public class EnrollmentPlanAddDTO extends EnrollmentPlan {
    @Override
    @Schema(hidden = true)
    public Long getId() {
        return super.getId();
    }
}
