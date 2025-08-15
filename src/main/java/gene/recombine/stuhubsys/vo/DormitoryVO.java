package gene.recombine.stuhubsys.vo;

import lombok.Data;

import java.util.List;

@Data
public class DormitoryVO {
    private Long dormId;
    private String dormInfo;
    private List<String> studentList;
}
