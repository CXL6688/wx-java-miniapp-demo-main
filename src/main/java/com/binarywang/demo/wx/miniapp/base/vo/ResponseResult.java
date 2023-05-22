package com.binarywang.demo.wx.miniapp.base.vo;

import lombok.Data;

import java.io.Serializable;
@Data
public class ResponseResult<T>  implements Serializable {
    private int code;

    private String msg;

    private T data;

    public ResponseResult(int code, T data, String msg){
        this.code=code;
        this.data = data;
        this.msg=msg;
    }

    public static ResponseResult<String> SUCCESS(){
        return new ResponseResult(0,"","SUCCESS");
    }

    public static ResponseResult<String> SUCCESS(Object obj){
        return new ResponseResult(0,obj,"SUCCESS");
    }
}
