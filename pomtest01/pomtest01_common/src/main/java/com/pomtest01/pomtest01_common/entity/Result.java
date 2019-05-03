package com.pomtest01.pomtest01_common.entity;

import java.util.Collection;

/**
 * 控制类返回结果
 * */
public class Result{
    private boolean flag;   //是否成功
    private Integer code;   //返回码
    private String message; //返回信息
    private Object data;    //返回数据

    public Result(boolean b, int ok, String 增加成功) {
    }

    public Result(boolean flag, Integer code, String message, Object data) {
        this.flag = flag;
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
