package gene.recombine.stuhubsys.controller;

import gene.recombine.stuhubsys.common.result.CommonResult;
import gene.recombine.stuhubsys.entity.Major;
import gene.recombine.stuhubsys.service.MajorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("major")
@Tag(name = "专业")
public class MajorController {
    @Autowired
    private MajorService majorService;

    @GetMapping("byCollege")
    @Operation(summary = "获取专业信息")
    @Parameter(name = "collegeId", description = "学院id")
    public CommonResult<List<Major>> major(@RequestParam(name = "collegeId") Long collegeId) {
        return CommonResult.success(majorService.listMajor(collegeId));
    }

    @GetMapping("byName")
    @Operation(summary = "查询专业(模糊查询)")
    @Parameter(name = "majorName", description = "专业名")
    public CommonResult<List<Major>> getMajorListByName(@RequestParam(name = "majorName") String majorName) {
        return CommonResult.success(majorService.getMajorListByName(majorName));
    }
}
