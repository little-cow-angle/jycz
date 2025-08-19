package gene.recombine.stuhubsys.controller;

import gene.recombine.stuhubsys.vo.AdmissionRecordVO;
import gene.recombine.stuhubsys.vo.ReportVO;
import gene.recombine.stuhubsys.common.result.CommonResult;
import gene.recombine.stuhubsys.dto.AdmissionRecordDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO: 统计招生数据
 */
@RestController
@RequestMapping("reports")
@Tag(name = "录取数据")
public class ReportController {
/*    @GetMapping("registration")
    @Operation(summary = "按条件查询报名数据")
    @Parameter(name = "groupBy", description = "分组条件", example = "province",required = true)
    public CommonResult<List<ReportVO>> registrationStats(@RequestParam(value = "groupBy", defaultValue = "province") String groupBy) {
        List<ReportVO> list = new ArrayList<>();
        return CommonResult.success(list);
    }

    @PostMapping("admission")
    @Operation(summary = "获取录取学生名单")
    public CommonResult<List<AdmissionRecordVO>> admissionStats(@RequestBody AdmissionRecordDTO admissionRecordDTO) {
        List<AdmissionRecordVO> admissionRecordVOS = new ArrayList<>();
        return CommonResult.success(admissionRecordVOS);
    }*/
}
