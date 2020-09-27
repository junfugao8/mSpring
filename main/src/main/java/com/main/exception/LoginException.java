package com.main.exception;

import lombok.Data;

@Data
public class LoginException extends RuntimeException {

    private Integer code;

    public LoginException (Integer code, String msg){
        super(msg);
        this.code = code;
    }
}
