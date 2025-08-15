package gene.recombine.stuhubsys.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Teacher extends Person {
    @Schema(description = "教师id")
    private Long teacherId;
    //private ArrayList<Integer> classList;
}
