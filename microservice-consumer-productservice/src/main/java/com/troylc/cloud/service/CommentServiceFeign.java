package com.troylc.cloud.service;

import com.troylc.cloud.vbean.ResultInfo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by troylc on 2017/3/19.
 */
@FeignClient(name = "microservice-sidecar-comment")
public interface CommentServiceFeign {
    @RequestMapping(value = "/comment", method = RequestMethod.GET)
    ResultInfo getComment() throws Exception;
}
