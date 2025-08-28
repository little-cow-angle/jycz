package gene.recombine.stuhubsys.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import gene.recombine.stuhubsys.common.result.CommonResult;
import gene.recombine.stuhubsys.dto.DormitoryDTO;
import gene.recombine.stuhubsys.dto.StudentDTO;
import gene.recombine.stuhubsys.entity.Student;
import gene.recombine.stuhubsys.service.StudentService;
import gene.recombine.stuhubsys.vo.StudentDormVO;
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

    @PostMapping("withDorm")
    @Operation(summary = "查询住宿学生信息")
    public CommonResult<IPage<StudentDormVO>> getStudentsWithDorm(@RequestBody DormitoryDTO dormitoryDTO) {
        return CommonResult.success(studentService.getStudentDormVOs(dormitoryDTO));
    }

    @PutMapping("update")
    @Operation(summary = "修改学生信息")
    public CommonResult updateStudent(@RequestBody Student student) {
        return CommonResult.success(studentService.updateById(student));
    }

    @GetMapping("{id}")
    @Operation(summary = "获取学生信息(单条)")
    public CommonResult<StudentVO> getStudentById(@PathVariable("id") Long id) {
        return CommonResult.success(studentService.getStudentById(id));
    }

    @PostMapping("select-bed")
    @Operation(summary = "选择床位")
    public CommonResult selectBedNumber(@RequestBody StudentDTO studentDTO) {
        studentService.setStudentBedNumber(studentDTO);
        return CommonResult.success();
    }
}