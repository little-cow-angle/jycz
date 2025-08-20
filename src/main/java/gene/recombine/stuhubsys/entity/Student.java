package gene.recombine.stuhubsys.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@TableName(value ="student")
@Data
public class Student {

    @TableId(type = IdType.AUTO)
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
    @Schema(description = "专业id")
    private Long majorId;
    @Schema(description = "邮箱")
    private String email;
    @Schema(description = "性别")
    private String sex;
    @Schema(description = "报名号")
    private String signUpCode;
    @Schema(description = "宿舍id")
    private Long dormId;
    @Schema(description = "床位号")
    private Integer bedNumber;
    @Schema(description = "密码")
    private String password;
    @Schema(description = "学院id")
    private Integer collegeId;
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
    @Schema(description = "高考号")
    private String gaoKaoId;
    @Schema(description = "民族")
    private String nationality;
    @Schema(description = "户口类型")
    private String cityCountryside;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Student other = (Student) that;
        return (this.getStudentId() == null ? other.getStudentId() == null : this.getStudentId().equals(other.getStudentId()))
            && (this.getStudentName() == null ? other.getStudentName() == null : this.getStudentName().equals(other.getStudentName()))
            && (this.getStudentAddress() == null ? other.getStudentAddress() == null : this.getStudentAddress().equals(other.getStudentAddress()))
            && (this.getStudentNo() == null ? other.getStudentNo() == null : this.getStudentNo().equals(other.getStudentNo()))
            && (this.getClassId() == null ? other.getClassId() == null : this.getClassId().equals(other.getClassId()))
            && (this.getStudentAge() == null ? other.getStudentAge() == null : this.getStudentAge().equals(other.getStudentAge()))
            && (this.getMajorId() == null ? other.getMajorId() == null : this.getMajorId().equals(other.getMajorId()))
            && (this.getEmail() == null ? other.getEmail() == null : this.getEmail().equals(other.getEmail()))
            && (this.getSex() == null ? other.getSex() == null : this.getSex().equals(other.getSex()))
            && (this.getSignUpCode() == null ? other.getSignUpCode() == null : this.getSignUpCode().equals(other.getSignUpCode()))
            && (this.getDormId() == null ? other.getDormId() == null : this.getDormId().equals(other.getDormId()))
            && (this.getBedNumber() == null ? other.getBedNumber() == null : this.getBedNumber().equals(other.getBedNumber()))
            && (this.getPassword() == null ? other.getPassword() == null : this.getPassword().equals(other.getPassword()))
            && (this.getCollegeId() == null ? other.getCollegeId() == null : this.getCollegeId().equals(other.getCollegeId()))
            && (this.getPhone() == null ? other.getPhone() == null : this.getPhone().equals(other.getPhone()))
            && (this.getBirth() == null ? other.getBirth() == null : this.getBirth().equals(other.getBirth()))
            && (this.getGaoKao() == null ? other.getGaoKao() == null : this.getGaoKao().equals(other.getGaoKao()))
            && (this.getPoliticalIdentity() == null ? other.getPoliticalIdentity() == null : this.getPoliticalIdentity().equals(other.getPoliticalIdentity()))
            && (this.getEntryDate() == null ? other.getEntryDate() == null : this.getEntryDate().equals(other.getEntryDate()))
            && (this.getGaoKaoId() == null ? other.getGaoKaoId() == null : this.getGaoKaoId().equals(other.getGaoKaoId()))
            && (this.getNationality() == null ? other.getNationality() == null : this.getNationality().equals(other.getNationality()))
            && (this.getCityCountryside() == null ? other.getCityCountryside() == null : this.getCityCountryside().equals(other.getCityCountryside()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getStudentId() == null) ? 0 : getStudentId().hashCode());
        result = prime * result + ((getStudentName() == null) ? 0 : getStudentName().hashCode());
        result = prime * result + ((getStudentAddress() == null) ? 0 : getStudentAddress().hashCode());
        result = prime * result + ((getStudentNo() == null) ? 0 : getStudentNo().hashCode());
        result = prime * result + ((getClassId() == null) ? 0 : getClassId().hashCode());
        result = prime * result + ((getStudentAge() == null) ? 0 : getStudentAge().hashCode());
        result = prime * result + ((getMajorId() == null) ? 0 : getMajorId().hashCode());
        result = prime * result + ((getEmail() == null) ? 0 : getEmail().hashCode());
        result = prime * result + ((getSex() == null) ? 0 : getSex().hashCode());
        result = prime * result + ((getSignUpCode() == null) ? 0 : getSignUpCode().hashCode());
        result = prime * result + ((getDormId() == null) ? 0 : getDormId().hashCode());
        result = prime * result + ((getBedNumber() == null) ? 0 : getBedNumber().hashCode());
        result = prime * result + ((getPassword() == null) ? 0 : getPassword().hashCode());
        result = prime * result + ((getCollegeId() == null) ? 0 : getCollegeId().hashCode());
        result = prime * result + ((getPhone() == null) ? 0 : getPhone().hashCode());
        result = prime * result + ((getBirth() == null) ? 0 : getBirth().hashCode());
        result = prime * result + ((getGaoKao() == null) ? 0 : getGaoKao().hashCode());
        result = prime * result + ((getPoliticalIdentity() == null) ? 0 : getPoliticalIdentity().hashCode());
        result = prime * result + ((getEntryDate() == null) ? 0 : getEntryDate().hashCode());
        result = prime * result + ((getGaoKaoId() == null) ? 0 : getGaoKaoId().hashCode());
        result = prime * result + ((getNationality() == null) ? 0 : getNationality().hashCode());
        result = prime * result + ((getCityCountryside() == null) ? 0 : getCityCountryside().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", studentId=").append(studentId);
        sb.append(", studentName=").append(studentName);
        sb.append(", studentAddress=").append(studentAddress);
        sb.append(", studentNo=").append(studentNo);
        sb.append(", classId=").append(classId);
        sb.append(", studentAge=").append(studentAge);
        sb.append(", majorId=").append(majorId);
        sb.append(", email=").append(email);
        sb.append(", sex=").append(sex);
        sb.append(", signUpCode=").append(signUpCode);
        sb.append(", dormId=").append(dormId);
        sb.append(", bedNumber=").append(bedNumber);
        sb.append(", password=").append(password);
        sb.append(", collegeId=").append(collegeId);
        sb.append(", phone=").append(phone);
        sb.append(", birth=").append(birth);
        sb.append(", gaoKao=").append(gaoKao);
        sb.append(", politicalIdentity=").append(politicalIdentity);
        sb.append(", entryDate=").append(entryDate);
        sb.append(", gaoKaoId=").append(gaoKaoId);
        sb.append(", nationality=").append(nationality);
        sb.append(", cityCountryside=").append(cityCountryside);
        sb.append("]");
        return sb.toString();
    }
}