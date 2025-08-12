package gene.recombine.stuhubsys.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class person {
    private Integer majorId;
    private String id;
    private String name;
    private String phone;
    private LocalDate birthday;
    private Boolean sex;
    private Integer age;
    private String email;
    private String address;
}
