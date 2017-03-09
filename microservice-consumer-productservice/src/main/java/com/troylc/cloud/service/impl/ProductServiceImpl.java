package com.troylc.cloud.service.impl;

import com.troylc.cloud.bean.ProductBean;
import com.troylc.cloud.bean.UserBean;
import com.troylc.cloud.service.IProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by troylc on 2017/3/5.
 */
@Service
public class ProductServiceImpl implements IProductService{

    @Autowired
    private RestTemplate restTemplate;
    private static final Logger LOGGER = LoggerFactory.getLogger(ProductServiceImpl.class);


    //@HystrixCommand(fallbackMethod = "fallback")
    public UserBean getUserById(Long id) throws Exception {
        return this.restTemplate.getForObject("http://microservice-provider-userservice/" + id, UserBean.class);
    }

    @Override
    public ProductBean getCommodityById(Long commodityId) throws Exception {
        ProductBean productBean = new ProductBean("WSDA12345","XXXXXXX","13.76","A类",1200);
        return productBean;
    }

    /**
     * hystrix fallback方法
     *
     * @param id id
     * @return 默认的用户
     */
    public UserBean fallback(Long id) {
        ProductServiceImpl.LOGGER.info("异常发生，进入fallback方法，接收的参数：id = {}", id);
        UserBean user = new UserBean();
        user.setId(-1L);
        user.setUsername("默认用户名");
        user.setAge(0);
        return user;
    }
}
