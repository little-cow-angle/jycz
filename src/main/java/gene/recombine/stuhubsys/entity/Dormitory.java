package gene.recombine.stuhubsys.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * 
 * @TableName dormitory
 */
@TableName(value ="dormitory")
@Data
public class Dormitory {

    @TableId(type = IdType.AUTO)
    @Schema(description = "宿舍id", hidden = true)
    private Long dormId;
    @Schema(description = "园区", example = "A区", requiredMode = Schema.RequiredMode.REQUIRED)
    private String park;
    @Schema(description = "所属楼栋", example = "2号楼", requiredMode = Schema.RequiredMode.REQUIRED)
    private String building;
    @Schema(description = "楼层", example = "2", requiredMode = Schema.RequiredMode.REQUIRED)
    private Integer floor;
    @Schema(description = "宿舍号", example = "206", requiredMode = Schema.RequiredMode.REQUIRED)
    private Integer dormNumber;
    @Schema(description = "当前居住人数")
    private Integer currentNum;

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
        Dormitory other = (Dormitory) that;
        return (this.getDormId() == null ? other.getDormId() == null : this.getDormId().equals(other.getDormId()))
            && (this.getPark() == null ? other.getPark() == null : this.getPark().equals(other.getPark()))
            && (this.getBuilding() == null ? other.getBuilding() == null : this.getBuilding().equals(other.getBuilding()))
            && (this.getFloor() == null ? other.getFloor() == null : this.getFloor().equals(other.getFloor()))
            && (this.getDormNumber() == null ? other.getDormNumber() == null : this.getDormNumber().equals(other.getDormNumber()))
            && (this.getCurrentNum() == null ? other.getCurrentNum() == null : this.getCurrentNum().equals(other.getCurrentNum()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getDormId() == null) ? 0 : getDormId().hashCode());
        result = prime * result + ((getPark() == null) ? 0 : getPark().hashCode());
        result = prime * result + ((getBuilding() == null) ? 0 : getBuilding().hashCode());
        result = prime * result + ((getFloor() == null) ? 0 : getFloor().hashCode());
        result = prime * result + ((getDormNumber() == null) ? 0 : getDormNumber().hashCode());
        result = prime * result + ((getCurrentNum() == null) ? 0 : getCurrentNum().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", dormId=").append(dormId);
        sb.append(", park=").append(park);
        sb.append(", building=").append(building);
        sb.append(", floor=").append(floor);
        sb.append(", dormNumber=").append(dormNumber);
        sb.append(", currentNum=").append(currentNum);
        sb.append("]");
        return sb.toString();
    }
}