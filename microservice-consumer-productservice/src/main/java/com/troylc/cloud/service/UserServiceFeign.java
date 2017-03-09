package com.troylc.cloud.service;



import com.troylc.cloud.service.impl.UserServiceFeignFallback;
import com.troylc.feignconfig.FeignConfig;
import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * Created by troylc on 2017/3/6.
 */
// name为服务名，对应spring.application.name。注意：此服务名必须已注册进Eureka服务中心
@FeignClient(name = "microservice-provider-userservice",fallback = UserServiceFeignFallback.class, configuration = FeignConfig.class)
public interface UserServiceFeign extends IUserService{

}
