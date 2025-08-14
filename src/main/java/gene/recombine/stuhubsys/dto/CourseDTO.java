package gene.recombine.stuhubsys.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CourseDTO {
    @Schema(description = "课程名(模糊查询)")
    private String courseName;
    @Schema(description = "课程类型", example = "必修")
    private String courseType;
    @Schema(description = "当前页码", example = "1")
    private int pageNo = 1;
    @Schema(description = "分页大小", example = "10")
    private int pageSize = 10;
    @Schema(description = "教师姓名(模糊查询)", example = "李")
    private String teacherName;
    @Schema(description = "专业id", example = "100")
    private Long majorId;
    @Schema(description = "专业名(模糊查询)", example = "软件")
    private String majorName;
}

