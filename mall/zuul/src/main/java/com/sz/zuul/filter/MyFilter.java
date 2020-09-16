package com.sz.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import com.sz.commons.utils.JWTUtil;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.stereotype.Component;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class MyFilter extends ZuulFilter {
    /**
     * 确定过滤器类型，返回不同的字符串代表在不同生命周期起作用
     * pre ：可以在请求被路由之前调用
     * route ：在路由请求时候被调用
     * post ：在 route 和 error 过滤器之后被调用
     * error ：处理请求时发生错误时被调用
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 通过 int 值来定义过滤器的执行顺序
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 返回一个 boolean 类型来判断该过滤器是否要执行，所以通过此函数可实现过滤器的开关。
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 处理具体业务逻辑
     */
    @Override
    public Object run() throws ZuulException {
        //得到当前上下文对象
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletResponse response = requestContext.getResponse();
        //得到请求对象
        HttpServletRequest request = requestContext.getRequest();
        String uri = request.getRequestURI();
        String token = request.getHeader("token");
        System.out.println("经过网关。。。请求路径"+uri);
        //放行静态资源
        if(uri.contains(".")){
            String suffix = uri.substring(uri.lastIndexOf("."));
            if(".js".equals(suffix)||".css".equals(suffix)||".ico".equals(suffix)||".jpg".equals(suffix)||".png".equals(suffix)){
                return null;
            }
        }
        if("login".equals(uri.substring(uri.length()-5))||"login.html".equals(uri.substring(uri.length()-10))){
            return null;
        }
        if(token==null){
            Cookie[] cookie = request.getCookies();
            if(cookie!=null){
                for (Cookie cookie1 : cookie) {
                    if("token".equals(cookie1.getName())){
                        token = cookie1.getValue();
                    }
                }
            }
        }
        try {
            //验证token
            Claims claims = JWTUtil.parseJwt(token);
            return null;
        }catch(ExpiredJwtException expiredJwtException){
            System.out.println("token已过期！");
        }catch (Exception exception){
            System.out.println("token解析出错");
        }
        try {
            response.sendRedirect("/client/html/login.html");
        } catch (IOException e) {
            e.printStackTrace();
        }
        //阻止向下执行
        requestContext.setSendZuulResponse(false);
        requestContext.setResponseStatusCode(403);
        requestContext.setResponseBody("无权访问！");
        requestContext.getResponse().setContentType("text/html;charset=UTF-8");
        return null;
    }
}
