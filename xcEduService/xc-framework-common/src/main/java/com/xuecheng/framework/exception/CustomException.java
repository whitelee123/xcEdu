package com.xuecheng.framework.exception;

import com.xuecheng.framework.model.response.ResponseResult;
import com.xuecheng.framework.model.response.ResultCode;

/**
 * @author jojo
 * @date 2019/12/10 23:45
 **/
public class CustomException extends RuntimeException {
    //RuntimeException是非侵入式的异常
    ResultCode resultCode;

    public CustomException(ResultCode resultCode){
        this.resultCode=resultCode;
    }

    public ResultCode getResultCode(){
        return resultCode;
    }
}
