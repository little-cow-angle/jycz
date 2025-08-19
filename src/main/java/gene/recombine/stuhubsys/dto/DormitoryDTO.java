package gene.recombine.stuhubsys.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DormitoryDTO {
    @Schema(description = "园区", example = "芙蓉园")
    private String park;
    @Schema(description = "所属楼栋", example = "1栋")
    private String building;
    @Schema(description = "楼层", example = "1")
    private Integer floor;
    @Schema(description = "宿舍号", example = "101")
    private Integer dormNumber;
    @Schema(description = "学生姓名")
    private String studentName;
    @Schema(description = "学生id")
    private String studentId;
    @Schema(description = "学院id")
    private Long collegeId;
    @Schema(description = "专业id")
    private Long majorId;
    @Schema(description = "当前页码", example = "1")
    private int pageNo = 1;
    @Schema(description = "分页大小", example = "10")
    private int pageSize = 10;
}
