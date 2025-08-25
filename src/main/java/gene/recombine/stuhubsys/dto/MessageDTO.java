package gene.recombine.stuhubsys.dto;

import com.baomidou.mybatisplus.annotation.TableName;
import gene.recombine.stuhubsys.common.enums.MessageType;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
@Data
public class MessageDTO {
    @Schema(description = "消息类型")
    private MessageType type;
    @Schema(description = "预览")
    private String head;
    @Schema(description="消息主体")
    private String message;
    @Schema(description="消息主体")
    private LocalDateTime createTime;
    @Schema(description="附件路径")
    private List<AttachmentDTO> files;
    @Schema(description="若类型为通知公告，则有通知的id")
    private Integer notice_id;
}
