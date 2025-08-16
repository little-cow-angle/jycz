package gene.recombine.stuhubsys.controller;

import gene.recombine.stuhubsys.common.result.CommonResult;
import gene.recombine.stuhubsys.dto.AuthLoginDto;
import gene.recombine.stuhubsys.service.AuthService;
import gene.recombine.stuhubsys.vo.CourseVO;
import gene.recombine.stuhubsys.vo.Person;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
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
    public CommonResult login(@RequestBody AuthLoginDto auth) {
        return CommonResult.success(authService.login(auth));
    }

    @GetMapping("test/auth")
    @Operation(summary = "测试权限")
    public CommonResult login() {
        return CommonResult.success("我是管理员");
    }
}
