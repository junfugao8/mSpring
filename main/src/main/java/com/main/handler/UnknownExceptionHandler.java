package com.main.handler;

import com.main.enums.ResultEnum;
import com.main.utils.ResultVOUtil;
import com.main.vo.ResultVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

//@ControllerAdvice
public class UnknownExceptionHandler {

    private final static Logger logger = LoggerFactory.getLogger(UnknownExceptionHandler.class);

    @ResponseBody
    @ExceptionHandler(Exception.class)
    public ResultVO handler(Exception e){
        logger.error(e.getMessage());
        return ResultVOUtil.error(ResultEnum.UNKONW_ERROR.getCode(),ResultEnum.UNKONW_ERROR.getMsg());
    }

}
