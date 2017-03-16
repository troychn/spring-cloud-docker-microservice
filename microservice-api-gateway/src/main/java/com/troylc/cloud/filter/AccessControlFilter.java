package com.troylc.cloud.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.troylc.cloud.utils.ReturnInfoEnum;
import com.troylc.cloud.vbean.ResultInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by troylc on 2017/3/14.
 * 自定义过滤器的实现，需要继承ZuulFilter，需要重写实现下面四个方法：
 * filterType：返回一个字符串代表过滤器的类型，在zuul中定义了四种不同生命周期的过滤器类型，具体如下：
 * pre：可以在请求被路由之前调用
 * routing：在路由请求时候被调用
 * post：在routing和error过滤器之后被调用
 * error：处理请求时发生错误时被调用
 * filterOrder：通过int值来定义过滤器的执行顺序
 * shouldFilter：返回一个boolean类型来判断该过滤器是否要执行，所以通过此函数可实现过滤器的开关。
 * 在上例中，我们直接返回true，所以该过滤器总是生效。
 * run：过滤器的具体逻辑。需要注意，这里我们通过ctx.setSendZuulResponse(false)令zuul过滤该请求，
 * 不对其进行路由，然后通过ctx.setResponseStatusCode(401)设置了其返回的错误码，
 * 当然我们也可以进一步优化我们的返回，比如，通过ctx.setResponseBody(body)对返回body内容进行编辑，
 * 如果有中文乱码。则可以：ctx.getResponse().setContentType("text/html;charset=UTF-8")
 */
@Component
public class AccessControlFilter extends ZuulFilter {

    private static Logger log = LoggerFactory.getLogger(AccessControlFilter.class);

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        log.info(String.format("%s request to %s", request.getMethod(), request.getRequestURL().toString()));
        Object accessToken = request.getParameter("accessToken");
        if (accessToken == null) {
            log.warn("access token is empty,please enter accessToken!");
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            //未认证
            ResultInfo resultInfo = new ResultInfo<>(ReturnInfoEnum.NOT_AUTHENTICATE.getState(),ReturnInfoEnum.NOT_AUTHENTICATE.getStateInfo());
            ctx.getResponse().setContentType("text/html;charset=UTF-8");
            ctx.getResponse().setContentType(String.valueOf(MediaType.APPLICATION_JSON));
            ctx.setResponseBody(resultInfo.toString());
            return null;
        }
        log.info("access token ok");
        return null;
    }

}
