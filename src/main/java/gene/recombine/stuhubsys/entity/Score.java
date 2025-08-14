package gene.recombine.stuhubsys.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@TableName(value ="score")
@Data
public class Score {

    @TableId(type = IdType.AUTO)
    private Long scoreId;
    @Schema(description = "学生id")
    private Long studentId;
    @Schema(description = "课程成绩")
    private Integer scoreScore;
    @Schema(description = "课程id")
    private Long courseId;

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
        Score other = (Score) that;
        return (this.getScoreId() == null ? other.getScoreId() == null : this.getScoreId().equals(other.getScoreId()))
            && (this.getStudentId() == null ? other.getStudentId() == null : this.getStudentId().equals(other.getStudentId()))
            && (this.getScoreScore() == null ? other.getScoreScore() == null : this.getScoreScore().equals(other.getScoreScore()))
            && (this.getCourseId() == null ? other.getCourseId() == null : this.getCourseId().equals(other.getCourseId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getScoreId() == null) ? 0 : getScoreId().hashCode());
        result = prime * result + ((getStudentId() == null) ? 0 : getStudentId().hashCode());
        result = prime * result + ((getScoreScore() == null) ? 0 : getScoreScore().hashCode());
        result = prime * result + ((getCourseId() == null) ? 0 : getCourseId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", scoreId=").append(scoreId);
        sb.append(", studentId=").append(studentId);
        sb.append(", scoreScore=").append(scoreScore);
        sb.append(", courseId=").append(courseId);
        sb.append("]");
        return sb.toString();
    }
}