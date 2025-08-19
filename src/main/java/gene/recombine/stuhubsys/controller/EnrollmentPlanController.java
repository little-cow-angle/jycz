package gene.recombine.stuhubsys.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import gene.recombine.stuhubsys.common.result.CommonResult;
import gene.recombine.stuhubsys.entity.EnrollLimit;
import gene.recombine.stuhubsys.dto.EnrollmentPlanAddDTO;
import gene.recombine.stuhubsys.dto.EnrollmentPlanDTO;
import gene.recombine.stuhubsys.entity.EnrollmentPlan;
import gene.recombine.stuhubsys.service.EnrollmentPlanService;
import gene.recombine.stuhubsys.vo.EnrollmentPlanVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("enrollment")
@Tag(name="招生计划管理")
@Slf4j
public class EnrollmentPlanController {
    @Autowired
    private EnrollmentPlanService enrollmentPlanService;

    @GetMapping("{id}")
    @Operation(summary = "查询招生计划(单条)")
    @Parameter(name="id", description = "要查询的招生计划id")
    public CommonResult<EnrollmentPlan> getEnrollmentPlanList(@PathVariable("id") Integer id) {
        return CommonResult.success(enrollmentPlanService.getById(id));
    }

    @PostMapping("add")
    @Operation(summary = "新增招生计划")
    @io.swagger.v3.oas.annotations.parameters.RequestBody(
        required = true,
        content = @Content(
            mediaType = "application/json",
            schema = @Schema(implementation = EnrollmentPlanAddDTO.class)
        )
    )
    public CommonResult addPlan(@RequestBody EnrollmentPlan plan) {
        return CommonResult.success(enrollmentPlanService.save(plan));
    }

    @PutMapping("update")
    @Operation(summary = "修改招生计划")
    public CommonResult updatePlan(@RequestBody EnrollmentPlan plan) {
        return CommonResult.success(enrollmentPlanService.updateById(plan));
    }

    @DeleteMapping("{id}")
    @Operation(summary = "删除招生计划")
    @Parameter(name="id", description = "要删除的招生计划id")
    public CommonResult deletePlan(@PathVariable("id") Integer id) {
        return CommonResult.success(enrollmentPlanService.removeById(id));
    }

    @PostMapping("plan-list")
    @Operation(summary = "查询招生计划(条件)")
    public CommonResult<IPage<EnrollmentPlanVO>> planList(@RequestBody EnrollmentPlanDTO enrollmentPlanDTO) {
        return CommonResult.success(enrollmentPlanService.getEnrollmentPlanPages(enrollmentPlanDTO));
    }

    @PostMapping("set-limit")
    @Operation(summary = "设置招生限制")
    public CommonResult<String> setEnrollLimit(@RequestBody EnrollLimit enrollLimit) {
        return CommonResult.success(enrollmentPlanService.setEnrollLimit(enrollLimit));
    }

    @GetMapping("get-limit")
    @Operation(summary = "获取招生限制")
    public CommonResult<EnrollLimit> getEnrollLimit() {
        return CommonResult.success(enrollmentPlanService.getEnrollLimit());
    }
}
