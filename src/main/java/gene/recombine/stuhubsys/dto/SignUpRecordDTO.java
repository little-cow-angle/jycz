package gene.recombine.stuhubsys.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class SignUpRecordDTO {
    @Schema(hidden = true)
    private String id;
    @Schema(description = "志愿编号")
    private Integer epId;
    @Schema(hidden = true)
    private String studentId;
    @Schema(description = "志愿需要的信息，前端自定义，以JSON可是传输")
    private String data;
    @Schema(description = "志愿状态：(1,待审核）（2，录取）（3，驳回）（4，其他）")
    private Integer status;
    @Schema(description = "志愿顺序")
    private Integer order;
}
