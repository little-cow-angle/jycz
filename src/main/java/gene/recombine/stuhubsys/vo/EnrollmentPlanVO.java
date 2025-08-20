package gene.recombine.stuhubsys.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class EnrollmentPlanVO {
    @Schema(description = "招生计划id")
    private Long id;
    @Schema(description = "学费标准")
    private Integer price;
    @Schema(description = "学院名")
    private String collegeName;
    @Schema(description = "专业id")
    private Long majorId;
    @Schema(description = "专业名")
    private String majorName;
    @Schema(description = "计划人数")
    private Integer limit;
    @Schema(description = "已报人数")
    private Integer count;
    @Schema(description = "计划类型")
    private Integer type;
    @Schema(description = "计划描述")
    private String description;
}
