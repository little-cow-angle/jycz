package gene.recombine.stuhubsys.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class TextbookVO {
    @Schema(description = "教材id")
    private Long textbookId;
    @Schema(description = "教材名")
    private String textbookName;
    @Schema(description = "出版社")
    private String publisher;
    @Schema(description = "作者")
    private String author;
    @Schema(description = "课程id")
    private Long courseId;
    @Schema(description = "课程名")
    private String courseName;
    @Schema(description = "教材价格")
    private Double price;
}
