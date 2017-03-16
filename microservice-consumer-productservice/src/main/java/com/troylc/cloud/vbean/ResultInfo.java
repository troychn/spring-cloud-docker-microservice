package com.troylc.cloud.vbean;

import java.io.Serializable;

/**
 * 所有的Rest请求的返回类型封装JSON结果
 * Created by troylc on 2017/2/28.
 */
public class ResultInfo<T> implements Serializable {

    private String code;

    private T data;

    private String mesagess;

    public ResultInfo() {
    }

    public ResultInfo(String code, String mesagess) {
        this.code = code;
        this.mesagess = mesagess;
    }

    public ResultInfo(String code, String mesagess, T data) {
        this.code = code;
        this.mesagess = mesagess;
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMesagess() {
        return mesagess;
    }

    public void setMesagess(String mesagess) {
        this.mesagess = mesagess;
    }

    @Override
    public String toString() {
        return "ResultInfo{" +
                "code=" + code +
                ", data=" + data +
                ", error='" + mesagess + '\'' +
                '}';
    }
}
