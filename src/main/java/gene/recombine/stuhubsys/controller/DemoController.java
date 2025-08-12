package gene.recombine.stuhubsys.controller;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.DynamicParameter;
import com.github.xiaoymin.knife4j.annotations.DynamicParameters;
import gene.recombine.stuhubsys.dto.UserDTO;
import gene.recombine.stuhubsys.common.result.CommonResult;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Demo")
@Tag(name = "模版Controller")
@Slf4j
public class DemoController {
    @GetMapping
    @Operation(summary = "Get方法模版")
    public CommonResult<Object> GetDemo(    @Parameter( description = "用户ID",
                                                        required = true,
                                                        example = "1")
                                             Long id) {
        log.info(id.toString());
        return CommonResult.success("Get模版");
    }
    @PostMapping
    @ApiOperationSupport(
            author = "张三",
            params = @DynamicParameters(
                    name = "userCreateDTO",
                    properties = {
                            @DynamicParameter(name = "id", value = "用户id", required = true)
                    }
            )
    )
    @Operation(summary = "post方法模版")
    public CommonResult<Object> PostDemo(@RequestBody UserDTO userDTO) {
        log.info(String.valueOf(userDTO.getUsername()));
        return CommonResult.success("POST模版");
    }
}
