package com.troylc.cloud.controller;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.troylc.cloud.bean.ProductBean;
import com.troylc.cloud.bean.UserBean;
import com.troylc.cloud.service.CommentServiceFeign;
import com.troylc.cloud.service.IProductService;
import com.troylc.cloud.service.UserServiceFeign;
import com.troylc.cloud.service.impl.UserServiceFeignRest;
import com.troylc.cloud.utils.ReturnInfoEnum;
import com.troylc.cloud.vbean.ResultInfo;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 测试商品controol
 * Created by troylc on 2017/3/5.
 */
@RestController
public class ProductControoler {

    private static Logger log = LoggerFactory.getLogger(ProductControoler.class);

    @Autowired
    private IProductService productService;

    @Autowired
    private UserServiceFeign userServiceFeign;

    @Autowired
    private CommentServiceFeign commentServiceFeign;

    @Autowired
    private UserServiceFeignRest userServiceFeignRest;

    /**
     * 注：@GetMapping("/{id}")是spring 4.3的新注解等价于：
     *
     * @param id
     * @return user信息
     * @RequestMapping(value = "/id", method = RequestMethod.GET)
     * 类似的注解还有@PostMapping等等
     */
    @ApiOperation(value = "查找用户,通过spring cloud feign方式", notes = "根据用户的ID，查找对应的用户")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, paramType = "path", dataType = "Long")
    @HystrixCommand(commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000"),
            @HystrixProperty(name = "execution.timeout.enabled", value = "false")})
    @GetMapping("/getUsers/{id}")
    public ResultInfo getUserById(@PathVariable Long id) {
        UserBean userBean = null;
        try {
            ResultInfo<UserBean> resultInfo = userServiceFeign.getUserById(id);
            userBean = resultInfo.getData();
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
            return new ResultInfo<UserBean>(ReturnInfoEnum.SYSTEM_ERROR.getState(), ReturnInfoEnum.SYSTEM_ERROR.getStateInfo());
        }
        return new ResultInfo<>(ReturnInfoEnum.SUCCESS.getState(), ReturnInfoEnum.SUCCESS.getStateInfo(), userBean);
    }

    /**
     * 注：@GetMapping("/{id}")是spring 4.3的新注解等价于：
     *
     * @param id
     * @return user信息
     * @RequestMapping(value = "/id", method = RequestMethod.GET)
     * 类似的注解还有@PostMapping等等
     */
    @ApiOperation(value = "查找库存端口", notes = "根据端口的ID，查找对应的商品信息")
    @ApiImplicitParam(name = "id", value = "商品ID", required = true, paramType = "path", dataType = "Long")
    @GetMapping("/getCommodityBean/{id}")
    public ResultInfo getCommodityBeanById(@PathVariable Long id) {
        ProductBean productBean = null;
        try {
            productBean = productService.getCommodityById(id);
        } catch (Exception e) {
            log.error(e.getMessage());
            return new ResultInfo<ProductBean>(ReturnInfoEnum.SYSTEM_ERROR.getState(), ReturnInfoEnum.SYSTEM_ERROR.getStateInfo());
        }
        return new ResultInfo<>(ReturnInfoEnum.SUCCESS.getState(), ReturnInfoEnum.SUCCESS.getStateInfo(), productBean);
    }


    @ApiOperation(value = "查找用户,通过spring RestTemplate方式", notes = "根据用户的ID，查找对应的用户")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, paramType = "path", dataType = "Long")
    @HystrixCommand(commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000"),
            @HystrixProperty(name = "execution.timeout.enabled", value = "false")})
    @RequestMapping(value = "/users-rest/{id}", method = RequestMethod.GET)
    public ResultInfo getUserByRest(@PathVariable Long id) {
        UserBean userBean = null;
        try {
            ResultInfo<UserBean> resultInfo = userServiceFeignRest.getUser(id);
            userBean =  resultInfo.getData();
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
            return new ResultInfo<UserBean>(ReturnInfoEnum.SYSTEM_ERROR.getState(), ReturnInfoEnum.SYSTEM_ERROR.getStateInfo());
        }
        return new ResultInfo<>(ReturnInfoEnum.SUCCESS.getState(), ReturnInfoEnum.SUCCESS.getStateInfo(), userBean);
    }


    @ApiOperation(value = "获取商品评价，sidecar-nodejs方式", notes = "获取商品评价")
    @HystrixCommand(commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000"),
            @HystrixProperty(name = "execution.timeout.enabled", value = "false")})
    @RequestMapping(value = "/getComment", method = RequestMethod.GET)
    public ResultInfo getComment() {
        ResultInfo<Object> resultInfo = null;
        try {
            resultInfo = commentServiceFeign.getComment();
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
            return new ResultInfo<UserBean>(ReturnInfoEnum.SYSTEM_ERROR.getState(), ReturnInfoEnum.SYSTEM_ERROR.getStateInfo());
        }
        return new ResultInfo<>(ReturnInfoEnum.SUCCESS.getState(), ReturnInfoEnum.SUCCESS.getStateInfo(), resultInfo.getData());
    }

}
