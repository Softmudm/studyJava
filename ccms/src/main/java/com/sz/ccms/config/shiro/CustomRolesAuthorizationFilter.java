package com.sz.ccms.config.shiro;

import com.alibaba.fastjson.JSON;
import com.sz.ccms.utils.ResultBean;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authz.RolesAuthorizationFilter;
import org.springframework.http.HttpMethod;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * shiro原来是与的关系，重写isAccessAllowed方法
 * 实现roles["admin,test"]或关系
 */
public class CustomRolesAuthorizationFilter extends RolesAuthorizationFilter {
    @Override
    public boolean isAccessAllowed(ServletRequest servletRequest, ServletResponse servletResponse, Object o) {
        Subject subject = getSubject(servletRequest,servletResponse);
        String[] rolesArray = (String[]) o;
        //没有角色限制就都可以访问
        if(rolesArray==null||rolesArray.length==0){
            return true;
        }
        for (String s : rolesArray) {
            //若当前用户是rolesArray中的任何一个，则有权限访问
            if(subject.hasRole(s)){
                return true;
            }
        }
        return false;
    }
    //自定义的拦截器处理方法
    @Override
    public boolean onPreHandle(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
        HttpServletRequest servletRequest = (HttpServletRequest) request;
        HttpServletResponse servletResponse = (HttpServletResponse) response;
        //处理跨域问题，跨域的请求首先会发一个options类型的请求
        if (servletRequest.getMethod().equals(HttpMethod.OPTIONS.name())) {
            return true;
        }
        //调用上面的isAccessAllowed方法判断是否有权限
        boolean isAccess = isAccessAllowed(request, response, mappedValue);
        if (isAccess) {
            return true;
        }
        //下面是没有权限时的处理
        servletResponse.setCharacterEncoding("UTF-8");
        Subject subject = getSubject(request, response);
        PrintWriter printWriter = servletResponse.getWriter();
        servletResponse.setContentType("application/json;charset=UTF-8");
        servletResponse.setHeader("Access-Control-Allow-Origin", servletRequest.getHeader("Origin"));
        servletResponse.setHeader("Access-Control-Allow-Credentials", "true");
        servletResponse.setHeader("Vary", "Origin");
        String respStr;
        if (subject.getPrincipal() == null) {
            respStr = JSON.toJSONString(new ResultBean("您还未登录，请先登录"));
        } else {
            respStr = JSON.toJSONString(new ResultBean("您没有此权限，请联系管理员"));
        }
        printWriter.write(respStr);
        printWriter.flush();
        servletResponse.setHeader("content-Length", respStr.getBytes().length + "");
        return false;
    }
}
