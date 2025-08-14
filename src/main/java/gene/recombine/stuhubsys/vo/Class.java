package gene.recombine.stuhubsys.vo;

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
    private ArrayList<Person> studentList;
    private ArrayList<Person> teacherList;
}
