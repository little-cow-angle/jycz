package gene.recombine.stuhubsys.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class StudentDormVO {
    @Schema(description = "学生id")
    private Long studentId;
    @Schema(description = "学生姓名")
    private String studentName;
    @Schema(description = "床位号")
    private Integer bedNumber;
    @Schema(description = "专业id")
    private Long majorId;
    @Schema(description = "专业名")
    private String majorName;
    @Schema(description = "学院id")
    private Long collegeId;
    @Schema(description = "学院名")
    private String collegeName;
    @Schema(description = "宿舍id", hidden = true)
    private Long dormId;
    @Schema(description = "宿舍信息")
    private String dormInfo;
}
