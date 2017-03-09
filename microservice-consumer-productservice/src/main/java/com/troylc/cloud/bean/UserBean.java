package com.troylc.cloud.bean;

import java.io.Serializable;

/**
 * Created by troylc on 2017/3/5.
 */
public class UserBean implements Serializable{
    /**
     * 用户主键ID，自动增长
     */
    private Long id;

    /**
     * 用户姓名
     */
    private String username;

    /**
     * 用户名称
     */
    private Integer age;

    /**
     * 用户地址
     */
    private String address;

    public UserBean() {
        super();
    }

    public UserBean(String username, String address) {
        this.username = username;
        this.address = address;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return this.age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
