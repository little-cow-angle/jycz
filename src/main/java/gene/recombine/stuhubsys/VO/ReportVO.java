package gene.recombine.stuhubsys.VO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * 前端展示数据图表所需VO
 */
@Data
public class ReportVO {
    @Schema(description = "字段名(具体省份、年份或专业)", example = "四川省")
    String name;
    @Schema(description = "总条数", example = "100")
    Integer number;
}
