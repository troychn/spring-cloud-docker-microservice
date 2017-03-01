package com.troylc.cloud.vbean;

import java.io.Serializable;

/**
 * 所有的Rest请求的返回类型封装JSON结果
 * Created by troylc on 2017/2/28.
 */
public class ResultInfo<T> implements Serializable {

    private int success;

    private T data;

    private String mesagess;

    public ResultInfo(int success, String mesagess) {
        this.success = success;
        this.mesagess = mesagess;
    }

    public ResultInfo(int success, String mesagess, T data) {
        this.success = success;
        this.mesagess = mesagess;
        this.data = data;
    }

    public int isSuccess() {
        return success;
    }

    public void setSuccess(int success) {
        this.success = success;
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
                "success=" + success +
                ", data=" + data +
                ", error='" + mesagess + '\'' +
                '}';
    }
}
