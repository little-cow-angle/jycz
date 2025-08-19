package gene.recombine.stuhubsys.controller;

import gene.recombine.stuhubsys.common.result.CommonResult;
import gene.recombine.stuhubsys.entity.Teacher;
import gene.recombine.stuhubsys.service.TeacherService;
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
@RequestMapping("teacher")
@Tag(name = "教师数据")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    @GetMapping
    @Operation(summary = "查询教师列表")
    @Parameter(name = "teacherName", description = "教师姓名(模糊查询)")
    public CommonResult<List<Teacher>> getTeacherListByName(@RequestParam(name = "teacherName") String teacherName) {
        return CommonResult.success(teacherService.getTeacherListByName(teacherName));
    }
}
