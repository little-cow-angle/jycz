package gene.recombine.stuhubsys.common.exception;

import gene.recombine.stuhubsys.common.enums.GlobalErrorCodeConstants;
import gene.recombine.stuhubsys.common.result.CommonResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    /**
     * 出现异常返回错误提示, 并且回滚事务
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public CommonResult exceptionHandler(Exception e){
        System.err.println("捕获到异常");
        e.printStackTrace();
        return CommonResult.error(GlobalErrorCodeConstants.INTERNAL_SERVER_ERROR);
    }
}