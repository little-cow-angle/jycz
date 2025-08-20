package gene.recombine.stuhubsys.controller;

import gene.recombine.stuhubsys.common.result.CommonResult;
import gene.recombine.stuhubsys.dto.MessageDTO;
import gene.recombine.stuhubsys.entity.Major;
import gene.recombine.stuhubsys.service.MessageService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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

    @GetMapping("download")
    @Operation(summary = "下载附件")
    public ResponseEntity<Resource> downloadAttachment(@Parameter(description = "文件路径") String path) throws IOException {
        return messageService.download(path);
    }
//TODO    @PostMapping("uploadFile")
//    @Operation(summary = "上传附件")
//    public CommonResult uploadAttachment(@Parameter(description = "附件") MultipartFile file,@Parameter(description = "")) throws IOException {
//        return CommonResult.success();
//    }
}
