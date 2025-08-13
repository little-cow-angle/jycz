package gene.recombine.stuhubsys.VO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class AdmissionRecordVO extends Student {
    @Schema(description = "录取信息id", example = "100001")
    private Long admissionId;
    @Schema(description = "录取日期",example = "2025-08-10")
    private String admissionDate;

    @Override
    @Schema(hidden = true)
    public ArrayList<Integer> getSignUpRecordId() {
        return super.getSignUpRecordId();
    }
}
