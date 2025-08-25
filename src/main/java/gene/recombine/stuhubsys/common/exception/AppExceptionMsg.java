package gene.recombine.stuhubsys.common.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum AppExceptionMsg {
    //权限相关
    AUTH_PASSWORD_ERROR(600,"账号或密码错误"),
    AUTH_ADMIN_NOT_MATCHED(601,"账号类型不匹配"),
    AUTH_NOT_LOGIN(602,"未登录"),
    //填报志愿
    SIGN_UP_RECORD_OUT_OF_MAX_3(700,"志愿数量超过上限"),
    SIGN_UP_NOT_STUDENT(701,"你是老师哥们" ),
    SIGN_UP_ORDER_IS_NULL(702, "志愿序号为空！"),
    SIGN_UP_ORDER_IS_DUPLICATED(702, "志愿序号已存在！"),
    SIGN_UP_UNKNOWN_COMMAND(703, ""),
    //服务端异常
    SERVER_ERROR(500,"服务器异常"),
    //其他异常
    TRANSACTION_BED_NUMBER_HAS_EXISTED(800, "该床位已被选择！");

    private int code;
    private String msg;
}
