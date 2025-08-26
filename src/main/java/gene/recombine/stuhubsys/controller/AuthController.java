package gene.recombine.stuhubsys.controller;

import gene.recombine.stuhubsys.common.result.CommonResult;
import gene.recombine.stuhubsys.dto.AuthLoginDTO;
import gene.recombine.stuhubsys.dto.UserDTO;
import gene.recombine.stuhubsys.service.AuthService;
import gene.recombine.stuhubsys.vo.LoginUserVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("Auth/")
@Tag(name = "权限认证")
public class AuthController {
    @Autowired
    AuthService authService;

    @PostMapping("login")
    @Operation(summary = "登录")
    public CommonResult<LoginUserVO> login(@RequestBody AuthLoginDTO auth) {
        return CommonResult.success(authService.login(auth));
    }

    @GetMapping("info")
    @Operation(summary = "获取个人信息")
    public CommonResult<UserDTO> getInfo() {
        return CommonResult.success(authService.getInfo());
    }

    @PutMapping("info")
    @Operation(summary = "修改个人信息")
    public CommonResult getInfo(@RequestBody UserDTO user) {
        authService.setInfo(user);
        return CommonResult.success();
    }

}
