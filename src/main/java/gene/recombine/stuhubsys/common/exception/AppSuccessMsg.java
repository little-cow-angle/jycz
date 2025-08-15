package gene.recombine.stuhubsys.common.exception;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
public enum AppSuccessMsg {
    SUCCESS_MSG(200,"success"),
    ;
    private int code;
    private String msg;
    public int getCode() {
        return code;
    }
    public String getMsg() {
        return msg;
    }
}
