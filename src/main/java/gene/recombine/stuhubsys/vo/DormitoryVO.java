package gene.recombine.stuhubsys.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class DormitoryVO {
    @Schema(description = "宿舍id")
    private Long dormId;
    @Schema(description = "宿舍详情", example = "XX园X栋X楼XXX号")
    private String dormInfo;
    @Schema(description = "住宿学生名单")
    private List<Student> studentList;
}
