package gene.recombine.stuhubsys.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Teacher extends Person {
    private ArrayList<Integer> classList;
}
