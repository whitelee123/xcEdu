package com.xuecheng.framework.exception;

import com.xuecheng.framework.model.response.ResponseResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author jojo
 * @date 2019/12/10 23:51
 **/
@ControllerAdvice//通知增强，用于捕获异常
public class CustomExceptionCatch {

    //记录日志
    private final static Logger LOGGER = LoggerFactory.getLogger(CustomException.class);
    //用于捕获捕获自定义异常
    @ExceptionHandler
    @ResponseBody
    public ResponseResult customerException(CustomException e){
        LOGGER.error("catch execptiomn: {}",e.getMessage(),e);
        ResponseResult responseResult=new ResponseResult(e.getResultCode());
        return responseResult;
    }
}
