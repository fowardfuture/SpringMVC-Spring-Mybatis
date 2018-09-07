package com.action.controller.Interceptor;

import com.action.dto.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserIntercertor implements HandlerInterceptor {
    private static final String[] IGNORE_URI={"/addshop_cart","/order-forms"};
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        System.out.print("preHandle->");
        boolean flag=true;
        String servletpath=httpServletRequest.getServletPath();
        for (String s : IGNORE_URI)
        {
            if (servletpath.contains(s))
            {
                flag=false;
                break;
            }
        }
        if (!flag){
            User user=(User)httpServletRequest.getSession().getAttribute("user");
            if (null==user)
            {
                System.out.print("请先登录");
                httpServletRequest.setAttribute("message","请先登录");
                httpServletRequest.getRequestDispatcher("login").forward(httpServletRequest,httpServletResponse);
            }
            else flag=true;
        }
        return flag;
    }

    //当第一个函数返回值为true的时候执行 ，在Controller函数执行结束之后执行
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        System.out.print("postHandle");
    }

    //在前面两个函数返回值均为true的时候执行 ，主要作用用与清理资源
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
            System.out.print("afterCompletion");
    }
}
