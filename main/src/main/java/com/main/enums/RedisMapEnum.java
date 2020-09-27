package com.main.enums;

import lombok.Getter;

@Getter
public enum RedisMapEnum {

    VERIFY_CODE("1","验证码"),
    MANAGER_WEIGH("2","管理员等级"),
    ;

    private String key;

    private String name;

    RedisMapEnum(String key, String name) {
        this.key = key;
        this.name = name;
    }
}
