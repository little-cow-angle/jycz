package gene.recombine.stuhubsys.controller;

import gene.recombine.stuhubsys.common.result.CommonResult;
import gene.recombine.stuhubsys.service.CollegeService;
import gene.recombine.stuhubsys.vo.College;
import gene.recombine.stuhubsys.entity.Major;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("College/")
@Tag(name = "学院与专业")
public class CollegeController {
    @Autowired
    CollegeService collegeService;

    @GetMapping()
    @Operation(summary = "获取学院信息")
    public CommonResult<Collection<College>> list() {
        Collection<College> list = collegeService.list();
        CommonResult<Collection<College>> success = CommonResult.success(list);
        return success;
    }

    @GetMapping("major")
    @Operation(summary = "获取专业信息")
    @Parameter(name = "collegeId", description = "学院id")
    public CommonResult<List<Major>> major(@RequestParam(name = "collegeId") Long collegeId) {
        return CommonResult.success(collegeService.listMajor(collegeId));
    }

}
