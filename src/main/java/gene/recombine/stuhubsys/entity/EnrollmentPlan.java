package gene.recombine.stuhubsys.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@TableName(value ="enrollment_plan")
@Data
public class EnrollmentPlan {

    @TableId(type = IdType.AUTO)
    @Schema(description = "招生计划id")
    private Long id;
    @Schema(description = "学费标准", requiredMode = Schema.RequiredMode.REQUIRED)
    private Integer price;
    @Schema(description = "学院id", requiredMode = Schema.RequiredMode.REQUIRED)
    private Integer collegeId;
    @Schema(description = "专业id", requiredMode = Schema.RequiredMode.REQUIRED)
    private Integer majorId;
    @Schema(description = "计划人数")
    private Integer limit;
    @Schema(description = "已报人数")
    private Integer count;
    @Schema(description = "计划类型", requiredMode = Schema.RequiredMode.REQUIRED)
    private Integer type;
    @Schema(description = "计划描述")
    private String description;

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
        EnrollmentPlan other = (EnrollmentPlan) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getPrice() == null ? other.getPrice() == null : this.getPrice().equals(other.getPrice()))
            && (this.getCollegeId() == null ? other.getCollegeId() == null : this.getCollegeId().equals(other.getCollegeId()))
            && (this.getMajorId() == null ? other.getMajorId() == null : this.getMajorId().equals(other.getMajorId()))
            && (this.getLimit() == null ? other.getLimit() == null : this.getLimit().equals(other.getLimit()))
            && (this.getCount() == null ? other.getCount() == null : this.getCount().equals(other.getCount()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getDescription() == null ? other.getDescription() == null : this.getDescription().equals(other.getDescription()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getPrice() == null) ? 0 : getPrice().hashCode());
        result = prime * result + ((getCollegeId() == null) ? 0 : getCollegeId().hashCode());
        result = prime * result + ((getMajorId() == null) ? 0 : getMajorId().hashCode());
        result = prime * result + ((getLimit() == null) ? 0 : getLimit().hashCode());
        result = prime * result + ((getCount() == null) ? 0 : getCount().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", price=").append(price);
        sb.append(", collegeId=").append(collegeId);
        sb.append(", majorId=").append(majorId);
        sb.append(", limit=").append(limit);
        sb.append(", count=").append(count);
        sb.append(", type=").append(type);
        sb.append(", description=").append(description);
        sb.append("]");
        return sb.toString();
    }
}