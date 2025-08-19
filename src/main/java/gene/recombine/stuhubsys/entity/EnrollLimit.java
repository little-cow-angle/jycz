package gene.recombine.stuhubsys.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EnrollLimit {
    @Schema(description = "开始时间")
    private Date startTime;
    @Schema(description = "结束时间")
    private Date endTime;
    @Schema(description = "报名类型")
    private Integer limitType;
    @Schema(description = "人数限制")
    private Integer limitNumber;
}
