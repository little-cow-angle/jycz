package gene.recombine.stuhubsys.vo;

import lombok.Data;

@Data
public class StudentVolunteerVO {
    private Long studentId;
    private String studentName;
    private String sex;
    private String gaoKaoId;
    private String gaoKao;
    private String address;
    private String phone;
    private String huKou;
    private String collegeName;
    private SignUpRecordVO signUpRecord;
    private Integer status;
}
