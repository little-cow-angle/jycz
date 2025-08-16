package gene.recombine.stuhubsys.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 
 * @TableName student
 */
@TableName(value ="student")
@Data
public class Student {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Long studentId;

    /**
     * 
     */
    private String studentName;

    /**
     * 
     */
    private String studentBirth;

    /**
     * 
     */
    private String studentAddress;

    /**
     * 
     */
    private Long studentNo;

    /**
     * 
     */
    private Long classId;

    /**
     * 
     */
    private Integer studentAge;

    /**
     * 
     */
    private Long majorId;

    /**
     * 
     */
    private String email;

    /**
     * 
     */
    private Integer sex;

    /**
     * 
     */
    private String signUpCode;

    /**
     * 
     */
    private Long dormId;

    /**
     * 床位号
     */
    private Integer bedNumber;

    /**
     * 
     */
    private String password;

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
            && (this.getStudentBirth() == null ? other.getStudentBirth() == null : this.getStudentBirth().equals(other.getStudentBirth()))
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
            && (this.getPassword() == null ? other.getPassword() == null : this.getPassword().equals(other.getPassword()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getStudentId() == null) ? 0 : getStudentId().hashCode());
        result = prime * result + ((getStudentName() == null) ? 0 : getStudentName().hashCode());
        result = prime * result + ((getStudentBirth() == null) ? 0 : getStudentBirth().hashCode());
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
        sb.append(", studentBirth=").append(studentBirth);
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
        sb.append("]");
        return sb.toString();
    }
}