package gene.recombine.stuhubsys.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ScoreDTO {
    @Schema(description = "学生id", requiredMode = Schema.RequiredMode.REQUIRED)
    private Long studentId;
    @Schema(description = "课程id")
    private Long courseId;
    @Schema(description = "当前页码", example = "1")
    private int pageNo = 1;
    @Schema(description = "分页大小", example = "10")
    private int pageSize = 10;
}
