package com.main.enums;

import lombok.Getter;

@Getter
public enum ResultEnum {

    //基础
    UNKONW_ERROR(-1,"未知错误"),
    SUCCESE(0,"成功"),
    PARA_ERROR(1,"请求参数错误"),
    TOKEN_NOT_NULL(2,"token不存在或已过期"),

    //登录,系列号：1
    VERIFY_ERROR(11,"验证码不正确"),
    LOGIN_ERROR(12,"用户名或密码不正确"),

    //注册
    MANAGER_IS_EXIT(21,"用户已存在"),

    //College系列报错，系列号：5
    COLLEGE_NOT_EXIST(51,"不存在该系"),
    COLLEGE_NAME_ERROR(52,"系名不符合规定")
    ;


    private Integer code;

    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
