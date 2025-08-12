package gene.recombine.stuhubsys.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student extends Person {
    private String id;
    private Integer classId;
    private String signUpCode;
    private ArrayList<Integer> signUpRecordId;
}
