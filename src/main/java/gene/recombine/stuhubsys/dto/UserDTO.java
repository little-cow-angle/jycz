package gene.recombine.stuhubsys.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    @Schema(description = "用户名", example = "张三", requiredMode = Schema.RequiredMode.REQUIRED)
    private String username;
    @Schema(description = "入学年份", example = "张三", requiredMode = Schema.RequiredMode.REQUIRED)
    private String entryDate;
    @Schema(description = "姓名", example = "张三", requiredMode = Schema.RequiredMode.REQUIRED)
    private String name;
    @Schema(description = "性别", example = "男", requiredMode = Schema.RequiredMode.REQUIRED)
    private String sex;
    @Schema(description = "生日", example = "2003-12-06", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDate birth;
    @Schema(description = "高考证号", example = "2003-12-06", requiredMode = Schema.RequiredMode.REQUIRED)
    private String gaoKaoId;
    @Schema(description = "高考成绩", example = "2003-12-06", requiredMode = Schema.RequiredMode.REQUIRED)
    private String gaoKao;
    @Schema(description = "电话", example = "11451411451", requiredMode = Schema.RequiredMode.REQUIRED)
    private String phone;
    @Schema(description = "邮箱", example = "zhangming04822@foxmail.com", requiredMode = Schema.RequiredMode.REQUIRED)
    private String email;
    @Schema(description = "专业", example = "软件工程", requiredMode = Schema.RequiredMode.REQUIRED)
    private String major;
    @Schema(description = "所属学院", example = "软件工程", requiredMode = Schema.RequiredMode.REQUIRED)
    private String collegeName;
    @Schema(description = "办公室地址", example = "厕所", requiredMode = Schema.RequiredMode.REQUIRED)
    private String workAddress;
    @Schema(description = "职位", example = "辅导员", requiredMode = Schema.RequiredMode.REQUIRED)
    private String position;
}
