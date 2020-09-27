package com.main.exception;

import com.main.enums.ResultEnum;
import lombok.Data;

@Data
public class CollegeException extends RuntimeException{

    private Integer code;

    public CollegeException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

    public CollegeException(Integer code, String msg) {
        super(msg);
        this.code = code;
    }
}
