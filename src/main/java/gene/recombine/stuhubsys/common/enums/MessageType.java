package gene.recombine.stuhubsys.common.enums;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public enum MessageType {
    WORK("工作消息"),
    NOTICE("通知公告"),
    ;
    private String Type;
    public String getType() {
        return Type;
    }
}
