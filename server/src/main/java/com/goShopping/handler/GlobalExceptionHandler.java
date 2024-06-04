package com.goShopping.handler;
import com.goShopping.result.Result;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

@RestControllerAdvice
public class GlobalExceptionHandler {
        @ExceptionHandler(Exception.class)
        public Result handleException(Exception e){
            e.printStackTrace();

            return Result.error("操作失败,请检查");
        }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Result<Object> handleValidationException(MethodArgumentNotValidException ex) {
        Map<String, Object> errorMap = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error -> {
            errorMap.put(error.getField(), error.getDefaultMessage());
        });
        return Result.error(errorMap.size()+"个字段验证失败");
    }
}