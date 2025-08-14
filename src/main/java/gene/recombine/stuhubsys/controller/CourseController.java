package gene.recombine.stuhubsys.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import gene.recombine.stuhubsys.common.result.CommonResult;
import gene.recombine.stuhubsys.dto.CourseDTO;
import gene.recombine.stuhubsys.entity.Course;
import gene.recombine.stuhubsys.service.CourseService;
import gene.recombine.stuhubsys.vo.CourseVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("management/course")
@Tag(name = "课程管理")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @GetMapping("{id}")
    @Operation(summary = "查询课程(单条)")
    @Parameter(name = "id", description = "要查询的课程id")
    public CommonResult<CourseVO> getCourseById(@PathVariable long id) {
        return CommonResult.success(courseService.findCourseById(id));
    }

    @PostMapping("add")
    @Operation(summary = "新增课程")
    public CommonResult addCourse(@RequestBody Course course) {
        return CommonResult.success(courseService.save(course));
    }

    @PutMapping("update")
    @Operation(summary = "修改课程")
    public CommonResult updateCourse(@RequestBody Course course) {
        return CommonResult.success(courseService.updateById(course));
    }

    @DeleteMapping("{id}")
    @Operation(summary = "删除课程")
    @Parameter(name = "id", description = "要删除的课程id")
    public CommonResult deleteCourse(@PathVariable long id) {
        return CommonResult.success(courseService.removeById(id));
    }

    @PostMapping("course-list")
    @Operation(summary = "分页查询课程")
    public CommonResult<IPage<CourseVO>> getCourseList(@RequestBody CourseDTO courseDTO) {
        return CommonResult.success(courseService.getCourseVOListPage(courseDTO));
    }
}
