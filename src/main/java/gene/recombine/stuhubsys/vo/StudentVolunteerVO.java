package gene.recombine.stuhubsys.vo;

import lombok.Data;

@Data
public class StudentVolunteerVO {
    private Long studentId;
    private String studentName;
    private String sex;
    private String gao_kao_id;
    private String gao_kao;
    private String address;
    private String phone;
    private String huKou;
    private String collegeName;
    private SignUpRecordVO signUpRecord;
}
