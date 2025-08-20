package gene.recombine.stuhubsys.controller;

import gene.recombine.stuhubsys.common.result.CommonResult;
import gene.recombine.stuhubsys.dto.MessageDTO;
import gene.recombine.stuhubsys.entity.Major;
import gene.recombine.stuhubsys.service.MessageService;
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
@RequestMapping("message/")
@Tag(name = "消息")
public class MessageController {
    @Autowired
    MessageService messageService;
    @GetMapping("admin")
    @Operation(summary = "获取教师相关消息")
    public CommonResult<List<MessageDTO>> getAdminMessage() {
        return CommonResult.success(messageService.getAdminMessage());
    }

    @GetMapping("student")
    @Operation(summary = "获取学生相关消息")
    public CommonResult<List<MessageDTO>> getStudentMessage() {
        return CommonResult.success(messageService.getStudentMessage());
    }
}
