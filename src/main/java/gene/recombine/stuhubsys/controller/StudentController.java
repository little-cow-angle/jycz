package gene.recombine.stuhubsys.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import gene.recombine.stuhubsys.common.result.CommonResult;
import gene.recombine.stuhubsys.dto.StudentDTO;
import gene.recombine.stuhubsys.entity.Student;
import gene.recombine.stuhubsys.service.StudentService;
import gene.recombine.stuhubsys.vo.StudentVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("student")
@Tag(name = "学生管理")
public class StudentController {
    @Autowired
    StudentService studentService;

    @PostMapping("queryAll")
    @Operation(summary = "分页查询学生信息")
    public CommonResult<IPage<StudentVO>> getAllStudents(@RequestBody StudentDTO studentDTO) {
        return CommonResult.success(studentService.getStudentPages(studentDTO));
    }

    @PutMapping("update")
    @Operation(summary = "修改学生信息")
    public CommonResult updateStudent(@RequestBody Student student) {
        return CommonResult.success(studentService.updateById(student));
    }
}
