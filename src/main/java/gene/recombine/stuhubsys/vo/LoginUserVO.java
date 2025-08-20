package gene.recombine.stuhubsys.vo;

import gene.recombine.stuhubsys.entity.Menu;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Data
public class LoginUserVO {
    @Schema(description = "用户id")
    Long userId;
    @Schema(description = "用户名")
    String username;
    @Schema(description = "用户类型")
    String userType;
    @Schema(description = "token")
    String token;
    @Schema(description = "菜单")
    List<Menu> menus;
}
