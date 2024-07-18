package com.example.takeawaypro.bean;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Result<T> {
    private Integer code;  //状态码。0：成功 ，1：失败
    private String message;  //响应信息
    private T data;         //响应数据
    public Result(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }
    public static <E> Result<E> success(E date){
        return new Result<>(0,"操作成功",date);
    }
    //快速返回操作成功响应结果
    public static Result success() {
        return new Result(0, "操作成功", null);
    }
    public static Result error(String message) {
        return new Result(1, message, null);
    }
    /**
     * 获取
     * @return code
     */
    public Integer getCode() {
        return code;
    }

    /**
     * 设置
     * @param code
     */
    public void setCode(Integer code) {
        this.code = code;
    }

    /**
     * 获取
     * @return message
     */
    public String getMessage() {
        return message;
    }

    /**
     * 设置
     * @param message
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * 获取
     * @return data
     */
    public T getData() {
        return data;
    }

    /**
     * 设置
     * @param data
     */
    public void setData(T data) {
        this.data = data;
    }

    public String toString() {
        return "Result{code = " + code + ", message = " + message + ", data = " + data + "}";
    }


}
