package com.sky.girl.handle;

import com.sky.girl.domain.Result;
import com.sky.girl.exception.GirlException;
import com.sky.girl.utils.ResultUtil;
import com.sun.org.apache.bcel.internal.generic.NEW;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionHandle {
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result handle(Exception e){
        if(e instanceof GirlException){
            GirlException girlException=(GirlException) e;
            return ResultUtil.erro(girlException.getCode(),e.getMessage());
        }
       return ResultUtil.erro(0,e.getMessage());
    }
}
