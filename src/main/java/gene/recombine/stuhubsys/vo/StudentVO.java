package gene.recombine.stuhubsys.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Date;

@Data
public class StudentVO {

    @Schema(description = "学生id")
    private Long studentId;
    @Schema(description = "学生姓名")
    private String studentName;
    @Schema(description = "学生地址")
    private String studentAddress;
    @Schema(description = "学号")
    private Long studentNo;
    @Schema(description = "班级id")
    private Long classId;
    @Schema(description = "年龄")
    private Integer studentAge;
    @Schema(description = "邮箱")
    private String email;
    @Schema(description = "性别")
    private String sex;
    @Schema(description = "电话")
    private String phone;
    @Schema(description = "生日")
    private Date birth;
    @Schema(description = "高考成绩")
    private String gaoKao;
    @Schema(description = "政治面貌")
    private String politicalIdentity;
    @Schema(description = "入学时间")
    private Object entryDate;
    @Schema(description = "民族")
    private String nationality;
    @Schema(description = "户口类型")
    private String cityCountryside;
    @Schema(description = "学院名")
    private String collegeName;
    @Schema(description = "专业名")
    private String majorName;
    @Schema(description = "宿舍信息")
    private String dormInfo;

}