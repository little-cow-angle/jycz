package gene.recombine.stuhubsys.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class student extends person{
    private Integer id;
    private Integer classId;
    private String signUpCode;
    private ArrayList<Integer> signUpRecordId;
}
