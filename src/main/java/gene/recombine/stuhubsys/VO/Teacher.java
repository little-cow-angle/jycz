package gene.recombine.stuhubsys.VO;

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
