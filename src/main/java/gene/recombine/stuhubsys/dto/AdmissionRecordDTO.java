package gene.recombine.stuhubsys.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * description: 用于分页查询录取学生名单的DTO
 */
@Data
public class AdmissionRecordDTO {
    @Schema(description = "查询条件", example = "province", requiredMode = Schema.RequiredMode.REQUIRED)
    private String groupBy;
    @Schema(description = "当前页码", example = "1")
    private String pageNo;
    @Schema(description = "每页条数", example = "10")
    private String pageSize;
}
