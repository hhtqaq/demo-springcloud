package com.tvt.hht.apigateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author hht
 * @date 2019/7/18 10:35
 * @description 请求过滤
 * <p>
 * 实现了在骑牛被路由转发之前检查 HttpServletRequest中是否有accessToken参数，
 * 若有就进行路由，若没有就拒绝访问 返回401 Unauthorized错误
 */
@Component
public class AccessFilter extends ZuulFilter {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    private static final String ERROR_STATUS_CODE = "error.status_code";
    private static final String ERROR_EXCEPTION = "error.exception";

    private static final String ERROR_MESSAGE = "error.message";//自定义友好的异常信息

    /**
     * 过滤器类型 他决定过滤器在请求的那个生命周期中执行  pre=请求被路由转发之前
     *
     * @return
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 过滤器执行的顺序  当请求在一个阶段中存在多个过滤器时，需要根据该方法返回的值来依次执行
     *
     * @return
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 判断该过滤器是否需要被执行   true
     * 该过滤器对所有的请求都会生效
     * 实际运用中，可以利用该函数来指定过滤器的有效范围
     *
     * @return
     */
    @Override
    public boolean shouldFilter() {//判断该过滤器是否要执行
        return true;
    }

    /**
     * 过滤器的具体逻辑
     * 通过setSendZuulResponse（false）表示  不对齐进行路由转发
     *
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {
        //1获取当前请求上下文
        RequestContext ctx = RequestContext.getCurrentContext();
        try {
            //2 获取httpServletRequest
            HttpServletRequest request = ctx.getRequest();
            //3获取token
            Object accessToken = request.getParameter("accessToken");
            if (accessToken == null) {
                logger.error("没有携带token");
                ctx.setSendZuulResponse(false);
                ctx.setResponseStatusCode(401);
                return null;
            }
        } catch (Exception e) {
            ctx.set(ERROR_STATUS_CODE, HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            ctx.set(ERROR_EXCEPTION, e);
            ctx.set(ERROR_MESSAGE, "不好意思  路由转发错误");
        }
        logger.info("验证成功  即将交给路由转发");
        return null;
    }
}
