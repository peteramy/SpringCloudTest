package com.zuulService.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by peter on 2018/3/14.
 */
public class MyFilter extends ZuulFilter {

    private static final Logger logger= LoggerFactory.getLogger(MyFilter.class);
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
        RequestContext context=RequestContext.getCurrentContext();//获得当前context对象
        HttpServletRequest request=context.getRequest();
        Object object= request.getParameter("token");
        if(object==null){
            logger.warn("token is empty");
            context.setSendZuulResponse(false);
            context.setResponseStatusCode(401);
            try {
                context.getResponse().setContentType("text/html;charset=utf-8");
                context.getResponse().setCharacterEncoding("utf-8");
                context.getResponse().getWriter().write("token 为空！");
            }catch (IOException e){
                e.printStackTrace();
            }
        return null;
        }
        logger.info("ok");
        return null;
    }
}
