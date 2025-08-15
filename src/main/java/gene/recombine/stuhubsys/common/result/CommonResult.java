package gene.recombine.stuhubsys.common.result;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.fasterxml.jackson.annotation.JsonIgnore;
import gene.recombine.stuhubsys.common.exception.AppException;
import gene.recombine.stuhubsys.common.exception.AppExceptionMsg;
import gene.recombine.stuhubsys.common.exception.AppSuccessMsg;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.util.Assert;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * 通用返回
 *
 * @param <T> 数据泛型
 */
@Data
@Schema(description = "通用响应结果")
public class CommonResult<T> implements Serializable {

    /**
     * 错误码
     *
     * @see AppExceptionMsg#getCode()
     */

    @Schema(description = "状态码", example = "200")
    private Integer code;
    /**
     * 返回数据
     */

    @Schema(description = "返回数据")
    private T data;


    /**
     * 返回总数
     */

    @Schema(description = "返回总数", example = "1")
    private Long total;
    /**
     * 错误提示，用户可阅读
     *
     * @see AppExceptionMsg#getMsg()
     */

    @Schema(description = "提示信息", example = "操作成功")
    private String msg;

    /**
     * 将传入的 result 对象，转换成另外一个泛型结果的对象
     * 因为 A 方法返回的 CommonResult 对象，不满足调用其的 B 方法的返回，所以需要进行转换。
     *
     * @param result 传入的 result 对象
     * @param <T>    返回的泛型
     * @return 新的 CommonResult 对象
     */
    public static <T> CommonResult<T> error(CommonResult<?> result) {
        return error(result.getCode(), result.getMsg());
    }

    public static <T> CommonResult<T> error(Integer code, String message) {
        if(code==null){
            throw new NullPointerException();
        }
        Assert.isTrue(!(AppSuccessMsg.SUCCESS_MSG.getCode()== code), "code 必须是错误的！");
        CommonResult<T> result = new CommonResult<>();
        result.code = code;
        result.msg = message;
        return result;
    }
    public static <T> CommonResult<T> error(AppException error) {
        return error(error.getCode(), error.getMsg());
    }

    public static <T> CommonResult<List<T>> successPageData(IPage<T> page) {
        CommonResult<List<T>> result = new CommonResult<>();
        result.code = AppSuccessMsg.SUCCESS_MSG.getCode();
        result.data = page.getRecords();
        result.total = page.getTotal();
        result.msg = "";
        return result;
    }

    public static <T> CommonResult<T> success(T data) {
        CommonResult<T> result = new CommonResult<>();
        result.code = AppSuccessMsg.SUCCESS_MSG.getCode();
        result.data = data;
        result.msg = "";
        return result;
    }


    public static <T> CommonResult<T> success() {
        CommonResult<T> result = new CommonResult<>();
        result.code = AppSuccessMsg.SUCCESS_MSG.getCode();
        result.data = null;
        result.msg = "";
        return result;
    }


    public static boolean isSuccess(Integer code) {
        return Objects.equals(code, AppSuccessMsg.SUCCESS_MSG.getCode());
    }

    @JsonIgnore // 避免 jackson 序列化
    public boolean isSuccess() {
        return isSuccess(code);
    }

    @JsonIgnore // 避免 jackson 序列化
    public boolean isError() {
        return !isSuccess();
    }




}
