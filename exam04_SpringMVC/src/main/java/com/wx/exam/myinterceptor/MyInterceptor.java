package com.wx.exam.myinterceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//自定义拦截器类
public class MyInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        if(session.getAttribute("user")==null){
            request.setAttribute("msg","你没有登录，请先登录！！！");
            request.getRequestDispatcher("/WEB-INF/jsps/login.jsp").forward(request,response);
            return false;
        }
        return true;
    }

    //下面两个方法只有在上面这个返回true的时候调用
    //这个方法在渲染视图前被调用
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("视图渲染前");
    }
    //这个方法在拦截完成释放资源后调用
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("拦截完成");
    }
}
