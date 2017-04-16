package com.troylc.cloud.controller;

import com.troylc.cloud.bean.UserBean;
import com.troylc.cloud.service.IUserService;
import com.troylc.cloud.utils.ReturnInfoEnum;
import com.troylc.cloud.vbean.ResultInfo;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.ArrayList;
import java.util.List;

/**
 * Rest服务提供者，供其它服务调用
 * Created by troylc on 2017/2/28.
 */
@RefreshScope
@RestController
public class UserController {

    private static Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private IUserService userServiceImpl;


    @Value("${configfrom}")
    private String fromInfostr;
    /**
     * 获取所有用户
     * @return
     */
    @ApiOperation(value = "获取自动刷新后的配置文件中from中的值", notes = "获取自动刷新后的配置文件")
    @GetMapping("/from")
    public ResultInfo geFromInfo() {
        String fromInfostr = null;
        try {
            fromInfostr = this.fromInfostr;
        } catch (Exception e) {
            log.error(e.getMessage());
            return new ResultInfo<String>(ReturnInfoEnum.SYSTEM_ERROR.getState(), ReturnInfoEnum.SYSTEM_ERROR.getStateInfo());
        }
        return new ResultInfo<String>(ReturnInfoEnum.SUCCESS.getState(),ReturnInfoEnum.SUCCESS.getStateInfo(), fromInfostr);
    }

    /**
     * 获取所有用户
     *
     * @return
     */
    @ApiOperation(value = "获取用户列表", notes = "获取所有用户")
    @GetMapping("/users")
    public ResultInfo getUserList() {
        List<UserBean> userBeans = new ArrayList<>();
        try {
            userBeans = userServiceImpl.getAllUser();
        } catch (Exception e) {
            log.error(e.getMessage());
            return new ResultInfo<UserBean>(ReturnInfoEnum.SYSTEM_ERROR.getState(), ReturnInfoEnum.SYSTEM_ERROR.getStateInfo());
        }
        return new ResultInfo<List<UserBean>>(ReturnInfoEnum.SUCCESS.getState(), ReturnInfoEnum.SUCCESS.getStateInfo(), userBeans);
    }

    /**
     * 根据User对象创建用户
     * @param user
     * @return
     */
    @ApiOperation(value = "创建用户", notes = "根据User对象创建用户")
    @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "UserBean")
    @PostMapping("/users")
    public ResultInfo postUser(@RequestBody UserBean user) {
        try {
            userServiceImpl.saveUser(user);
        } catch (Exception e) {
            log.error(e.getMessage());
            return new ResultInfo<UserBean>(ReturnInfoEnum.SYSTEM_ERROR.getState(), ReturnInfoEnum.SYSTEM_ERROR.getStateInfo());
        }
        return new ResultInfo<UserBean>(ReturnInfoEnum.SUCCESS.getState(), ReturnInfoEnum.SUCCESS.getStateInfo());
    }


    /**
     * 注：@GetMapping("/{id}")是spring 4.3的新注解等价于：
     * @param id
     * @return user信息
     * @RequestMapping(value = "/id", method = RequestMethod.GET)
     * 类似的注解还有@PostMapping等等
     */
    @ApiOperation(value = "查找用户", notes = "根据用户的ID，查找对应的用户")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, paramType = "path", dataType = "Long")
    @GetMapping("/users/{id}")
    public ResultInfo findById(@PathVariable Long id) {
        UserBean userBean = null;
        try {
            userBean = userServiceImpl.getUserById(id);
            log.info(userBean.toString());
        } catch (Exception e) {
            log.error(e.getMessage());
            return new ResultInfo<UserBean>(ReturnInfoEnum.SYSTEM_ERROR.getState(), ReturnInfoEnum.SYSTEM_ERROR.getStateInfo());
        }
        ResultInfo resultInfo = new ResultInfo<UserBean>(ReturnInfoEnum.SUCCESS.getState(), ReturnInfoEnum.SUCCESS.getStateInfo(), userBean);
        return resultInfo;
    }

    /**
     * 根据url的id来指定更新对象，并根据传过来的user信息来更新用户详细信息
     * @param id
     * @param user
     * @return
     */
    @ApiOperation(value = "更新用户详细信息", notes = "根据url的id来指定更新对象，并根据传过来的user信息来更新用户详细信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户ID", required = true, paramType = "path", dataType = "Long"),
            @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
    })
    @PutMapping("/users/{id}")
    public ResultInfo updateUser(@PathVariable Long id, @RequestBody UserBean user) {
        try {
            user.setId(id);
            userServiceImpl.updateUser(user);
        } catch (Exception e) {
            log.error(e.getMessage());
            return new ResultInfo<UserBean>(ReturnInfoEnum.SYSTEM_ERROR.getState(), ReturnInfoEnum.SYSTEM_ERROR.getStateInfo());
        }
        return new ResultInfo<UserBean>(ReturnInfoEnum.SUCCESS.getState(), ReturnInfoEnum.SUCCESS.getStateInfo());
    }

    /**
     * 删除用户
     * @param id
     * @return
     */
    @ApiOperation(value = "删除用户", notes = "根据url的id来指定删除对象")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, paramType = "path", dataType = "Long")
    @DeleteMapping("/users/{id}")
    public ResultInfo deleteUser(@PathVariable Long id) {
        try {
            userServiceImpl.deleteUser(id);
        } catch (Exception e) {
            log.error(e.getMessage());
            return new ResultInfo<UserBean>(ReturnInfoEnum.SYSTEM_ERROR.getState(), ReturnInfoEnum.SYSTEM_ERROR.getStateInfo());
        }
        return new ResultInfo<UserBean>(ReturnInfoEnum.SUCCESS.getState(), ReturnInfoEnum.SUCCESS.getStateInfo());
    }


    /**
     * 本地服务实例的信息
     * @return
     */
    @ApiIgnore //swagger忽略此API，在前台暴露
    @GetMapping("/instance-info")
    public ServiceInstance showInfo() {
        ServiceInstance localServiceInstance = this.discoveryClient.getLocalServiceInstance();
        return localServiceInstance;
    }

}
