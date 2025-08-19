package gene.recombine.stuhubsys.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import gene.recombine.stuhubsys.common.result.CommonResult;
import gene.recombine.stuhubsys.dto.SignUpRecordDTO;
import gene.recombine.stuhubsys.service.SignUpService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("SignUp/")
@Tag(name = "填报志愿")
public class SignUpController {
    @Autowired
    SignUpService signUpService;
    @PostMapping()
    @Operation(summary = "添加志愿")
    public CommonResult add(@RequestBody SignUpRecordDTO record) {
        signUpService.add(record);
        return CommonResult.success();
    }
    @GetMapping()
    @Operation(summary = "查看个人志愿")
    public CommonResult getOwnList() {
        Collection<SignUpRecordDTO> sign=signUpService.getOwnList();
        return CommonResult.success(sign);
    }
    @GetMapping("admin")
    @Operation(summary = "分页条件查询所有人的志愿")
    public CommonResult list(@Parameter(required = false,description = "可更具志愿类型来查询") Integer epId,
                             @Parameter(required = true,description = "页码") Integer page,
                             @Parameter(required = true,description = "每页展示数") Integer size) {
        IPage<SignUpRecordDTO> sign=signUpService.list(epId,page,size);
        return CommonResult.success(sign);
    }

    @PutMapping("admin/operate")
    @Operation(summary = "志愿操作")
    public CommonResult operate(
                             @Parameter(required = true,description = "志愿编号") Integer id,
                             @Parameter(required = true,description = "操作码(1,待审核）（2，录取）（3，驳回）（4，其他）") Integer operate) {
        signUpService.operate(id,operate);
        return CommonResult.success();
    }
}
