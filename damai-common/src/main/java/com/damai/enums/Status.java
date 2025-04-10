package com.damai.enums;

/**
 * @program:
 * @description: 状态
 * @author:  旷智仁
 **/

public enum Status {
    /**
     * 基础状态
     * */
    RUN(1,"正常"),
    STOP(0,"禁用")
    ;

    private Integer code;

    private String msg;

    Status(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }
    
    public String getMsg() {
        return this.msg == null ? "" : this.msg;
    }
    
    public static String getMsg(Integer code) {
        for (Status re : Status.values()) {
            if (re.code.intValue() == code.intValue()) {
                return re.msg;
            }
        }
        return "";
    }

    public static Status getRc(Integer code) {
        for (Status re : Status.values()) {
            if (re.code.intValue() == code.intValue()) {
                return re;
            }
        }
        return null;
    }
}
