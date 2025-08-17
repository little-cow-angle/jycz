package gene.recombine.stuhubsys.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class StudentDTO {
    @Schema(description = "学生姓名")
    private String studentName;
    @Schema(description = "学生地址")
    private String studentAddress;
    @Schema(description = "专业id")
    private Long majorId;
    @Schema(description = "学院id")
    private Integer collegeId;
    @Schema(description = "当前页码", example = "1")
    private int pageNo = 1;
    @Schema(description = "分页大小", example = "10")
    private int pageSize = 10;
}
