package gene.recombine.stuhubsys.common.exception;


import gene.recombine.stuhubsys.common.result.CommonResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class AppExceptionHandler {
    @ExceptionHandler(value={Exception.class})
    @ResponseBody
    public CommonResult appException(Exception e) {
        if(e instanceof AppException appException) {
            return CommonResult.error(appException);
        }
        return CommonResult.error(AppExceptionMsg.SERVER_ERROR.getCode(),e.getMessage());
    }
}
