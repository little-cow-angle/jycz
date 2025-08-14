package gene.recombine.stuhubsys.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnrollmentPlan {
    @Schema(description = "招生计划id")
    Integer id;
    @Schema(description = "招生专业id", example = "102")
    Integer majorId;
    @Schema(description = "招生年份", example = "2077")
    Integer year;
    @Schema(description = "招生省份", example = "四川省")
    String province;
    @Schema(description = "预收学费标准", example = "5000")
    Integer price;
}
