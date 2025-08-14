package gene.recombine.stuhubsys.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student extends Person {
    @Schema(description = "学生id")
    private String studentId;
    @Schema(description = "班级id")
    private Integer classId;
    @Schema(description = "专业id")
    private Integer majorId;
    @Schema(description = "报名号")
    private String signUpCode;
    @Schema(description = "报名记录id列表")
    private ArrayList<Integer> signUpRecordId;
}
