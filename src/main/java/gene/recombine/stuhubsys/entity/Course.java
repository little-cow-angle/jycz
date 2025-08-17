package gene.recombine.stuhubsys.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @TableName course
 */
@TableName(value ="course")
@Data
@NoArgsConstructor
public class Course {

    @TableId(type = IdType.AUTO)
    @Schema(description = "课程id")
    private Long courseId;

    @Schema(description = "课程名", example = "高等数学", requiredMode = Schema.RequiredMode.REQUIRED)
    private String courseName;

    @Schema(description = "教师id", example = "1001", requiredMode = Schema.RequiredMode.REQUIRED)
    private Integer teacherId;

    @Schema(description = "课时数", example = "48")
    private Integer courseLength;

    @Schema(description = "上课教室", example = "E1A202")
    private String courseClassroom;

    @Schema(description = "上课时间", example = "周一-周五1、2节")
    private String courseTime;

    @Schema(description = "专业id", example = "100", requiredMode = Schema.RequiredMode.REQUIRED)
    private Long majorId;

    @Schema(description = "课程类型", example = "必修")
    private String courseType;

    @Schema(description = "教材id")
    private Long textbookId;

    @Schema(description = "学分")
    private float credit;

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
        Course other = (Course) that;
        return (this.getCourseId() == null ? other.getCourseId() == null : this.getCourseId().equals(other.getCourseId()))
            && (this.getCourseName() == null ? other.getCourseName() == null : this.getCourseName().equals(other.getCourseName()))
            && (this.getTeacherId() == null ? other.getTeacherId() == null : this.getTeacherId().equals(other.getTeacherId()))
            && (this.getCourseLength() == null ? other.getCourseLength() == null : this.getCourseLength().equals(other.getCourseLength()))
            && (this.getCourseClassroom() == null ? other.getCourseClassroom() == null : this.getCourseClassroom().equals(other.getCourseClassroom()))
            && (this.getCourseTime() == null ? other.getCourseTime() == null : this.getCourseTime().equals(other.getCourseTime()))
            && (this.getMajorId() == null ? other.getMajorId() == null : this.getMajorId().equals(other.getMajorId()))
            && (this.getCourseType() == null ? other.getCourseType() == null : this.getCourseType().equals(other.getCourseType()))
            && (this.getTextbookId() == null ? other.getTextbookId() == null : this.getTextbookId().equals(other.getTextbookId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCourseId() == null) ? 0 : getCourseId().hashCode());
        result = prime * result + ((getCourseName() == null) ? 0 : getCourseName().hashCode());
        result = prime * result + ((getTeacherId() == null) ? 0 : getTeacherId().hashCode());
        result = prime * result + ((getCourseLength() == null) ? 0 : getCourseLength().hashCode());
        result = prime * result + ((getCourseClassroom() == null) ? 0 : getCourseClassroom().hashCode());
        result = prime * result + ((getCourseTime() == null) ? 0 : getCourseTime().hashCode());
        result = prime * result + ((getMajorId() == null) ? 0 : getMajorId().hashCode());
        result = prime * result + ((getCourseType() == null) ? 0 : getCourseType().hashCode());
        result = prime * result + ((getTextbookId() == null) ? 0 : getTextbookId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", courseId=").append(courseId);
        sb.append(", courseName=").append(courseName);
        sb.append(", teacherId=").append(teacherId);
        sb.append(", courseLength=").append(courseLength);
        sb.append(", courseClassroom=").append(courseClassroom);
        sb.append(", courseTime=").append(courseTime);
        sb.append(", majorId=").append(majorId);
        sb.append(", courseType=").append(courseType);
        sb.append(", textbookId=").append(textbookId);
        sb.append("]");
        return sb.toString();
    }
}