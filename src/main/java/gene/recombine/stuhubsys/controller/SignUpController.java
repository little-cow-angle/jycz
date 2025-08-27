package gene.recombine.stuhubsys.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import gene.recombine.stuhubsys.common.result.CommonResult;
import gene.recombine.stuhubsys.dto.SignUpRecordDTO;
import gene.recombine.stuhubsys.service.SignUpService;
import gene.recombine.stuhubsys.vo.StudentVolunteerVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("SignUp/")
@Tag(name = "填报志愿")
public class SignUpController {
    @Autowired
    SignUpService signUpService;

    @PostMapping
    @Operation(summary = "添加志愿")
    public CommonResult add(@RequestBody List<SignUpRecordDTO> records) {
        signUpService.add(records);
        return CommonResult.success();
    }

    @GetMapping("{id}")
    @Operation(summary = "查看个人志愿")
    @Parameter(name = "id", description = "学生id")
    public CommonResult getOwnList(@PathVariable("id") Long id) {
        return CommonResult.success(signUpService.getStudentVolunteer(id));
    }

    @GetMapping("admin")
    @Operation(summary = "分页条件查询志愿")
    @Parameter(name = "page", required = true, description = "页码")
    @Parameter(name = "size", required = true, description = "每页展示数")
    public CommonResult<IPage<StudentVolunteerVO>> list(Integer page, Integer size) {
        IPage<StudentVolunteerVO> sign = signUpService.getVolunteerList(page,size);
        return CommonResult.success(sign);
    }

    @PutMapping("admin/operate")
    @Operation(summary = "志愿操作")
    public CommonResult operate(
        @Parameter(required = true,description = "志愿编号") Integer id,
        @Parameter(required = true,description = "操作码(1,待审核)(2，录取)(3，驳回)(4，其他)") Integer operate) {
        signUpService.operate(id,operate);
        return CommonResult.success();
    }
}
