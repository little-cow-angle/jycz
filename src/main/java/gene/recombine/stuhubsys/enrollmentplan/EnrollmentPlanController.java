package gene.recombine.stuhubsys.enrollmentplan;

import gene.recombine.stuhubsys.entity.EnrollmentPlan;
import gene.recombine.stuhubsys.common.result.CommonResult;
import gene.recombine.stuhubsys.dto.EnrollmentPlanCreateDTO;
import gene.recombine.stuhubsys.dto.EnrollmentPlanDTO;
import gene.recombine.stuhubsys.service.EnrollmentPlanService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("enrollment-plan")
@Tag(name="招生计划")
@Slf4j
public class EnrollmentPlanController {
    @Autowired
    private EnrollmentPlanService enrollmentPlanService;

    /**
     * TODO: 查询
     */
    @GetMapping("{id}")
    @Operation(summary = "查询招生计划(单条)")
    @Parameter(name="id", description = "要查询的招生计划id")
    public CommonResult<EnrollmentPlan> getEnrollmentPlanList(@PathVariable("id") Integer id) {
        return CommonResult.success(enrollmentPlanService.getById(id));
    }

    /**
     * TODO：新增数据业务
     */
    @PostMapping("add")
    @Operation(summary = "新增招生计划")
    @io.swagger.v3.oas.annotations.parameters.RequestBody(
        required = true,
        content = @Content(
            mediaType = "application/json",
            schema = @Schema(implementation = EnrollmentPlanCreateDTO.class)
        )
    )
    public CommonResult<EnrollmentPlan> addPlan(@RequestBody EnrollmentPlan plan) {
        log.info(plan.toString());
        return CommonResult.success(plan);
    }

    @PutMapping("update")
    @Operation(summary = "修改招生计划")
    public CommonResult<EnrollmentPlan> updatePlan(@RequestBody EnrollmentPlan plan) {
        return CommonResult.success(plan);
    }

    @DeleteMapping("{id}")
    @Operation(summary = "删除招生计划")
    @Parameter(name="id", description = "要删除的招生计划id")
    public CommonResult deletePlan(@PathVariable("id") Integer id) {
        return CommonResult.success(id);
    }

    /**
     *
     * @param enrollmentPlanDTO 分页查询参数
     * @return IPage<EnrollmentPlan>
     */
    @PostMapping("plan-list")
    @Operation(summary = "查询招生计划(条件)")
    public CommonResult<EnrollmentPlan> planList(@RequestBody EnrollmentPlanDTO enrollmentPlanDTO) {
        return CommonResult.success(enrollmentPlanDTO);
    }
}
