package gene.recombine.stuhubsys.controller;

import gene.recombine.stuhubsys.common.result.CommonResult;
import gene.recombine.stuhubsys.service.CollegeService;
import gene.recombine.stuhubsys.entity.College;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("College/")
@Tag(name = "学院数据")
public class CollegeController {
    @Autowired
    CollegeService collegeService;

    @GetMapping()
    @Operation(summary = "获取学院信息")
    public CommonResult<Collection<College>> list() {
        Collection<College> list = collegeService.list();
        return CommonResult.success(list);
    }

}
