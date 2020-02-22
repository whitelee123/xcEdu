package com.xuecheng.framework.exception;


import com.xuecheng.framework.model.response.ResponseResult;
import com.xuecheng.framework.model.response.ResultCode;

/**
 * @author jojo
 * @date 2019/12/10 23:47
 **/
public class CustomExceptionCast {
    //定义一个静态方法抛出异常
    public static void customerExceptionCast(ResultCode resultCode){
        throw new CustomException(resultCode);
    }
}
