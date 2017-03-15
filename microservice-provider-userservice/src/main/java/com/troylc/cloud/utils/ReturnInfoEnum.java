package com.troylc.cloud.utils;

/**
 * 定义返回信息枚举
 * Created by troylc on 2017/2/28.
 */
public enum ReturnInfoEnum {

    SUCCESS("1", "请求操作成功"),
    NULL("0", "没有你请求的数据"),
    PARAMETER_ERROR("-1", "请求数据失败，参数错误"),
    SYSTEM_ERROR("-2", "请求数据失败，系统异常"),
    NOT_AUTHENTICATE("-3", "请求数据失败，未认证");


    private String state;

    private String stateInfo;

    ReturnInfoEnum(String state, String stateInfo) {
        this.state = state;
        this.stateInfo = stateInfo;
    }

    public String getState() {
        return state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public static ReturnInfoEnum stateOf(String index) {
        for (ReturnInfoEnum state : values()) {
            if (state.getState() == index) {
                return state;
            }
        }
        return null;
    }
}
