package gene.recombine.stuhubsys.VO;

import gene.recombine.stuhubsys.common.enums.SIGNUPRECORDSTATUS;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignUpRecord {
    private Integer enrollmentPlanId;
    private String studentId;
    private LocalDateTime createTime;
    private String data;
    private SIGNUPRECORDSTATUS status;
}
