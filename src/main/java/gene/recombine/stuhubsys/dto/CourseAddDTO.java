package gene.recombine.stuhubsys.dto;

import gene.recombine.stuhubsys.entity.Textbook;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class CourseAddDTO {
    @Schema(description = "课程id")
    private Long courseId;
    @Schema(description = "课程名", requiredMode = Schema.RequiredMode.REQUIRED)
    private String courseName;
    @Schema(description = "授课教师", requiredMode = Schema.RequiredMode.REQUIRED)
    private Integer teacherId;
    @Schema(description = "课时数")
    private Integer courseLength;
    @Schema(description = "上课教室")
    private String courseClassroom;
    @Schema(description = "上课时间", example = "周五1、2节")
    private String courseTime;
    @Schema(description = "专业id", example = "100", requiredMode = Schema.RequiredMode.REQUIRED)
    private Long majorId;
    @Schema(description = "课程类型", example = "必修")
    private String courseType;
    @Schema(description = "教材详情")
    private Textbook textbook;
    @Schema(description = "学分")
    private float credit;
}
