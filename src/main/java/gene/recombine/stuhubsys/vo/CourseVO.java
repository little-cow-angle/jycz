package gene.recombine.stuhubsys.vo;

import gene.recombine.stuhubsys.entity.Course;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class CourseVO extends Course {
    @Schema(description = "教师名")
    private String teacherName;
}
