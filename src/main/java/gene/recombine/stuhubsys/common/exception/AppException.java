package gene.recombine.stuhubsys.common.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppException extends RuntimeException{
    private int code;
    private String msg;
    public AppException(AppExceptionMsg appExceptionMsg) {
        this.code=appExceptionMsg.getCode();
        this.msg=appExceptionMsg.getMsg();
    }
}
