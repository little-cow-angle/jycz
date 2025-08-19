package gene.recombine.stuhubsys.controller;

import gene.recombine.stuhubsys.common.result.CommonResult;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("reports")
@Tag(name = "招生数据")
public class ReportController {
    // TODO：获取各类招生数据
    @GetMapping("gender")
    @Operation(summary = "获取性别分布")
    public CommonResult getGenderDistribution() {
        return CommonResult.success();
    }
}
