package gene.recombine.stuhubsys.VO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    @Schema(description = "专业id")
    private Integer majorId;
    private String id;
    @Schema(description = "姓名")
    private String name;
    @Schema(description = "电话")
    private String phone;
    @Schema(description = "生日")
    private LocalDate birthday;
    @Schema(description = "性别")
    private Boolean sex;
    @Schema(description = "年龄")
    private Integer age;
    @Schema(description = "电子邮箱")
    private String email;
    @Schema(description = "地址")
    private String address;
}
