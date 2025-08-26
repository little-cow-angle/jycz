package gene.recombine.stuhubsys.controller;

import gene.recombine.stuhubsys.common.result.CommonResult;
import gene.recombine.stuhubsys.service.ReportService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("reports")
@Tag(name = "招生数据")
public class ReportController {
    @Autowired
    private ReportService reportService;

    @GetMapping("{column}")
    @Operation(summary = "获取学生分布", description = "可以根据性别、政治面貌、户口类型等条件获取学生分布情况")
    @Parameter(name = "column", description = "要获取分布的类型", example = "sex")
    public CommonResult<List<Map<String, Object>>> getStuDistribution(@PathVariable String column) {
        return CommonResult.success(reportService.getStuDistributionByColumn(column));
    }

    @GetMapping("score")
    @Operation(summary = "学生成绩分布")
    public CommonResult<List<Map<String, Object>>> getStuScoreDistribution() {
        return CommonResult.success(reportService.getStuDistributionByScore());
    }

    @GetMapping
    @Operation(summary = "热门专业统计")
    public CommonResult<List<Map<String, Object>>> getHotMajorList() {
        return CommonResult.success(reportService.getHotMajorList());
    }
}
