package gene.recombine.stuhubsys.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class SignUpRecordDTO {
    @Schema(hidden = true)
    private String id;
    private Integer epId;
    @Schema(hidden = true)
    private String studentId;
    private String data;
    @Schema(description = "志愿状态：(1,待审核）（2，录取）（3，驳回）（4，其他）")
    private Integer status;
}
