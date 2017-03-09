package com.troylc.cloud.service.impl;

import com.troylc.cloud.service.UserServiceFeign;
import com.troylc.cloud.utils.ReturnInfoEnum;
import com.troylc.cloud.vbean.ResultInfo;
import org.springframework.stereotype.Component;

/**
 * 定义各接口对应的fallback方法
 * Created by troylc on 2017/3/6.
 */
@Component
public class UserServiceFeignFallback implements UserServiceFeign {

    @Override
    public ResultInfo getUserById(Long id) throws Exception {
        return new ResultInfo<>(ReturnInfoEnum.NULL.getState(), ReturnInfoEnum.NULL.getStateInfo());
    }

}
