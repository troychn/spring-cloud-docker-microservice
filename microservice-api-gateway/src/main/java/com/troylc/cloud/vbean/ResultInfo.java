package com.troylc.cloud.vbean;

import java.io.Serializable;

/**
 * 所有的Rest请求的返回类型封装JSON结果
 * Created by troylc on 2017/2/28.
 */
public class ResultInfo<T> implements Serializable {

    private String status;

    private T data;

    private String mesagess;

    public ResultInfo() {
    }

    public ResultInfo(String status, String mesagess) {
        this.status = status;
        this.mesagess = mesagess;
    }

    public ResultInfo(String status, String mesagess, T data) {
        this.status = status;
        this.mesagess = mesagess;
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
                "status=" + status +
                ", data=" + data +
                ", error='" + mesagess + '\'' +
                '}';
    }
}
