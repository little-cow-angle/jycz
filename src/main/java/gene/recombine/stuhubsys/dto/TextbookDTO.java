package gene.recombine.stuhubsys.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class TextbookDTO {
    @Schema(description = "教材id")
    private Long textbookId;
    @Schema(description = "课程id")
    private Long courseId;
    @Schema(description = "当前页码", example = "1")
    private int pageNo = 1;
    @Schema(description = "分页大小", example = "10")
    private int pageSize = 10;
}
