package com.cn.app.chatgptbot.exception;

import com.cn.app.chatgptbot.msg.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;


/**
 * The type Global interceptor.
 */
@RestControllerAdvice
@SuppressWarnings("all")
@Slf4j
public class GlobalInterceptor {


    /**
     * Exception handler result.
     *
     * @param e the e
     * @return the result
     */
    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public Result exceptionHandler(Exception e) {
        e.printStackTrace();
        if (e instanceof MethodArgumentNotValidException) {
            final List<ObjectError> allErrors = ((MethodArgumentNotValidException) e).getBindingResult().getAllErrors();
            return Result.error(allErrors.get(0).getDefaultMessage());
        }
        if (e instanceof CustomException) {
            return Result.error(e.getMessage());
        }
        if (e instanceof HttpRequestMethodNotSupportedException){
            return Result.error("请检查是否为POST请求方式");
        }
        return Result.error("接口异常或OpenAiKey已失效");
    }


}
