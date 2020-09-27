package com.main.handler;

import com.main.enums.ResultEnum;
import com.main.exception.CollegeException;
import com.main.exception.LoginException;
import com.main.utils.ResultVOUtil;
import com.main.vo.ResultVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@ResponseBody
public class BaseExceptionHandler {

    private final static Logger logger = LoggerFactory.getLogger(BaseExceptionHandler.class);

    @ExceptionHandler(value = CollegeException.class)
    public ResultVO collegeHandler(CollegeException e){
        logger.info(e.getMessage());
        return ResultVOUtil.error(e.getCode(),e.getMessage());
    }

    @ExceptionHandler(value = LoginException.class)
    public ResultVO loginHandler(LoginException e){
        logger.info(e.getMessage());
        return ResultVOUtil.error(e.getCode(),e.getMessage());
    }

    @ExceptionHandler(value = MissingServletRequestParameterException.class)
    public ResultVO servletRequestParameterHandler(MissingServletRequestParameterException e){
        logger.info(e.getMessage());
        return ResultVOUtil.error(ResultEnum.PARA_ERROR.getCode(),ResultEnum.PARA_ERROR.getMsg());
    }

}
