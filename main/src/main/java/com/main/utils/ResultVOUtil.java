package com.main.utils;

import com.main.vo.ResultVO;

public class ResultVOUtil {

    public static ResultVO succese(Object object){
        return new ResultVO(0,"成功",object);
    }

    public static ResultVO succese(){
        return succese(null);
    }

    public static ResultVO error(Integer code,String msg){
        return new ResultVO(code,msg,null);
    }
}
