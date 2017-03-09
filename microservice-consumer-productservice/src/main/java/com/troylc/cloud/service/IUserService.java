package com.troylc.cloud.service;

import com.troylc.cloud.bean.UserBean;
import com.troylc.cloud.vbean.ResultInfo;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 用户业务接口
 * Created by troylc on 2017/3/6.
 */
public interface IUserService {

    /**
     * 根据ID查的对应的用户
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
    ResultInfo<UserBean> getUserById(@PathVariable(value = "id") Long id) throws Exception;

}
