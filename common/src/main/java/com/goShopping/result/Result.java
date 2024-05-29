package com.goShopping.result;
import lombok.Data;

@Data
public class Result<T> {

    private Integer code; //编码：1成功，0和其它数字为失败
    private String msg; //响应信息
    private T data; //数据
    public static <T> Result<T> success() {
        Result<T> result = new Result<T>();
        result.code = 1;
        return result;
    }

    public static <T> Result<T> success(T object) {
        Result<T> result = new Result<T>();
        result.data = object;
        result.code = 1;
        return result;
    }

    public static <T> Result<T> error(String msg) {
        Result result = new Result();
        result.msg = msg;
        result.code = 0;
        return result;
    }
    public static <T> Result<T> error(String msg,T object){
         Result<T> result = new Result<>();
         result.data = object;
         result.code = 0;
         return result;
    }

}
