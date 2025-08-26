package gene.recombine.stuhubsys.controller;

import gene.recombine.stuhubsys.common.result.CommonResult;
import gene.recombine.stuhubsys.dto.AttachmentDTO;
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
//TODO  待测试......
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
    @PostMapping("uploadFile")
    @Operation(summary = "上传附件")
    public CommonResult uploadAttachment(@Parameter(description = "附件") MultipartFile file,@Parameter(description = "附件所属消息Id") Integer id) throws IOException {
        messageService.uploadAttachment(file,id);
        return CommonResult.success();
    }
    @GetMapping("attachmentInfo")
    @Operation(summary = "获取附件信息")
    public CommonResult<List<AttachmentDTO>> getAttachmentInfo(@Parameter(description = "消息ID") Integer Id) throws IOException {
        return CommonResult.success(messageService.getAttachment(Id));
    }
    @GetMapping("download")
    @Operation(summary = "下载附件")
    public ResponseEntity<byte[]> downloadAttachment(@Parameter(description = "附件ID") Integer Id) throws IOException {
        return messageService.download(Id);
    }

    @PostMapping("notice")
    @Operation(summary = "发布公告")
    public CommonResult uploadAttachment(
                                         @Parameter(description = "标题"          ) String head,
                                         @Parameter(description = "内容(JSON!!!)"       ) String payload          ) throws IOException {

        Integer id  =messageService.release(head,payload);
        return CommonResult.success(id);
    }
    @DeleteMapping("notice")
    @Operation(summary = "删除公告")
    public CommonResult deleteAttachment(@Parameter(description = "通知ID",required = true) Integer id) throws IOException {
        messageService.delete(id);
        return CommonResult.success(id);
    }
    @PutMapping("notice")
    @Operation(summary = "修改公告")
    public CommonResult updateAttachment(@Parameter(description = "通知ID",required = true) Integer id,
                                         @Parameter(description = "标题"          ) String head,
                                         @Parameter(description = "内容(JSON!!!)"       ) String payload          ) throws IOException {
        messageService.update(id,head,payload);
        return CommonResult.success();
    }
    @GetMapping("notice")
    @Operation(summary = "查询自己发布的公告")
    public CommonResult<List<MessageDTO>> getAttachment() throws IOException {
        List<MessageDTO> messageDTOS = messageService.get();
        return CommonResult.success(messageDTOS);
    }

}
