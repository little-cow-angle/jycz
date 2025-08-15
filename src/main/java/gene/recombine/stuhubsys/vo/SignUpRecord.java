package gene.recombine.stuhubsys.vo;

import gene.recombine.stuhubsys.common.enums.SIGN_UP_RECORD_STATUS;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignUpRecord {
    private Long enrollmentPlanId;
    private String studentId;
    private LocalDateTime createTime;
    private String data;
    private SIGN_UP_RECORD_STATUS status;
}
