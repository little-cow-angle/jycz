package gene.recombine.stuhubsys.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class ScoreVO {
    @Schema(description = "选课记录id")
    private Long scoreId;
    @Schema(description = "学生id")
    private Long studentId;
    @Schema(description = "学生姓名")
    private String studentName;
    @Schema(description = "课程id")
    private Long courseId;
    @Schema(description = "课程名", example = "高等数学")
    private String courseName;
    @Schema(description = "教师名")
    private String teacherName;
    @Schema(description = "上课教室", example = "E1A202")
    private String courseClassroom;
    @Schema(description = "上课时间", example = "周一-周五1、2节")
    private String courseTime;
    @Schema(description = "课程类型", example = "必修")
    private String courseType;
    @Schema(description = "教材id")
    private Long textbookId;
    @Schema(description = "学分")
    private float credit;
}
