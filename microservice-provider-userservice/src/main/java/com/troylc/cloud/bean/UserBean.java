package com.troylc.cloud.bean;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by troylc on 2017/2/27.
 */
@Entity
@Table(name="user")
public class UserBean implements Serializable{
    /**
     * 用户主键ID，自动增长
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * 用户姓名
     */
    @Column
    private String username;

    /**
     * 用户名称
     */
    @Column
    private Integer age;

    /**
     * 用户地址
     */
    @Column
    private String address;

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
