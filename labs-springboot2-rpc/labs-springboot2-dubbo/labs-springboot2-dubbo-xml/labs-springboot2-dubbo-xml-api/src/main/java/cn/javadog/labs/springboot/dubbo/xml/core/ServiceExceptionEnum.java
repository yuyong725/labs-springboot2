package cn.javadog.labs.springboot.dubbo.xml.core;

/**
 * @author 余勇
 * @date 2020-01-06 19:56
 * 业务异常枚举
 */
public enum ServiceExceptionEnum {

    // ========== 系统级别 ==========
    SUCCESS(0, "成功"),
    SYS_ERROR(2001001000, "服务端发生异常"),
    MISSING_REQUEST_PARAM_ERROR(2001001001, "参数缺失"),
    INVALID_REQUEST_PARAM_ERROR(2001001002, "请求参数不合法"),

    // ========== 用户模块 ==========
    USER_NOT_FOUND(1001002000, "用户不存在"),
    USER_EXISTS(1001002001, "用户已存在");

    /**
     * 错误码
     */
    private final int code;

    /**
     * 错误提示
     */
    private final String message;

    ServiceExceptionEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

}
