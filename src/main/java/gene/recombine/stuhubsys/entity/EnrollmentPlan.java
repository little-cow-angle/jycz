package gene.recombine.stuhubsys.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * 
 * @TableName enrollment_plan
 */
@TableName(value ="enrollment_plan")
@Data
public class EnrollmentPlan {

    @TableId(type = IdType.AUTO)
    @Schema(description = "招生计划id", requiredMode = Schema.RequiredMode.REQUIRED)
    private Long id;
    @Schema(description = "招生省份", example = "四川省")
    private String province;
    @Schema(description = "预收学费标准", example = "5000")
    private Integer price;
    @Schema(description = "招生专业id", example = "102")
    private Integer majorId;
    @Schema(description = "招生年份", example = "2077")
    private Integer year;

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
            && (this.getProvince() == null ? other.getProvince() == null : this.getProvince().equals(other.getProvince()))
            && (this.getPrice() == null ? other.getPrice() == null : this.getPrice().equals(other.getPrice()))
            && (this.getMajorId() == null ? other.getMajorId() == null : this.getMajorId().equals(other.getMajorId()))
            && (this.getYear() == null ? other.getYear() == null : this.getYear().equals(other.getYear()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getProvince() == null) ? 0 : getProvince().hashCode());
        result = prime * result + ((getPrice() == null) ? 0 : getPrice().hashCode());
        result = prime * result + ((getMajorId() == null) ? 0 : getMajorId().hashCode());
        result = prime * result + ((getYear() == null) ? 0 : getYear().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", province=").append(province);
        sb.append(", price=").append(price);
        sb.append(", majorId=").append(majorId);
        sb.append(", year=").append(year);
        sb.append("]");
        return sb.toString();
    }
}