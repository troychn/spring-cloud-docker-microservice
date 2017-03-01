package com.troylc.cloud.service.impl;

import com.troylc.cloud.bean.UserBean;
import com.troylc.cloud.dao.UserDaoRepository;
import com.troylc.cloud.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户业务处理接口实现类
 * Created by troylc on 2017/2/27.
 */
@Service
public class UserServiceImpl implements IUserService{

    private static Logger log = LoggerFactory.getLogger(UserServiceImpl.class);


    @Resource
    private UserDaoRepository userDaoRepository;

    @Override
    @Transactional
    public UserBean saveUser(UserBean userBean) throws Exception {
        return userDaoRepository.save(userBean);
    }

    @Override
    @Transactional
    public boolean deleteUser(Long Id) throws Exception {
        try{
            userDaoRepository.delete(Id);
            return true;
        } catch (Exception e){
             log.error(e.getMessage());
        }
        return false;
    }

    @Override
    public List<UserBean> getAllUser() throws Exception {
        return userDaoRepository.findAll();
    }

    @Override
    public UserBean getUserById(Long id) throws Exception {
        return userDaoRepository.findOne(id);
    }

    @Override
    @Transactional
    public boolean updateUser(UserBean userBean) throws Exception {
        return userDaoRepository.saveAndFlush(userBean)!=null?true:false;
    }
}
