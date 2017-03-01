package com.troylc.cloud.service;

import com.troylc.cloud.bean.UserBean;

import java.util.List;

/**
 * Created by troylc on 2017/2/27.
 * 用户业务逻辑处理层
 */
public interface IUserService {
    /**
     * 添加用户
     * @param userBean
     * @return
     */
     public UserBean saveUser(UserBean userBean) throws Exception ;

    /**
     * 根据ID删除用户
     * @param Id
     * @return
     */
     public boolean deleteUser(Long Id) throws Exception;

    /**
     * 获取所有用户的信息
     * @return
     */
     public List<UserBean> getAllUser() throws Exception;

    /**
     * 根据ID查的对应的用户
     * @param id
     * @return
     */
     public UserBean getUserById(Long id) throws Exception;

    /**
     * 更新用户信息
     * @param userBean
     * @return
     */
     public boolean updateUser(UserBean userBean) throws Exception;
}
