package gene.recombine.stuhubsys.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Class {
    private Integer id;
    private String name;
    private ArrayList<person> studentList;
    private ArrayList<person> teacherList;
}
