package com.swjtu.girl.enums;

/**
 * @author 李天峒
 * @date 2019/2/12 15:23
 *
 */
public enum ResultEnum {
    /***/
    UNLOGIN(500,"未登录系统"),
    /**未知错误*/
    UNKONW_ERROR (-1, "未知错误"),
    /** 成功*/
    SUCCESS(0,"成功"),
    /** 上小学*/
    PRIMARY_SCHOOL(100,"你可能还在上小学"),
    /** 上初中*/
    MIDDLE_SCHOOL(101,"你可能在上初中")
    ;

    private Integer code;

    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
