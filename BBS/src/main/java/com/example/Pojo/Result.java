package com.example.Pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result {
    private Integer code;
    private String msg;
    private Object data;


    //增删改，成功响应，data为null
    public static Result success(){
        return new Result(1,"success",null);
    }

    //查询成功响应
    public static Result success(Object data){
        return new Result(1,"success",data);
    }
    //响应失败
    public static Result error(){
        return new Result(0,"error",null);
    }
}
