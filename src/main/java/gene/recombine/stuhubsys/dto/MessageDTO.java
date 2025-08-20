package gene.recombine.stuhubsys.dto;

import com.baomidou.mybatisplus.annotation.TableName;
import gene.recombine.stuhubsys.common.enums.MessageType;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
@Data
public class MessageDTO {
    @Schema(description = "通知类型")
    private MessageType type;
    @Schema(description = "预览")
    private String head;
    @Schema(description="消息主体")
    private String message;
    @Schema(description="消息主体")
    private LocalDateTime createTime;
    @Schema(description="附件路径")
    private List<String> files;
}
