package com.cuisf.config;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginHandlerInterceptor implements HandlerInterceptor {

    /*
    *return ：ture 放行 false ： 不放行
    *
    *
    */

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        //用户登录成功后 会有session信息
        Object loginUser = request.getSession().getAttribute("loginUser");

        //没有登录
        if (loginUser == null) {
            request.setAttribute("msg", "没有登录权限，请先登录");
            request.getRequestDispatcher("/index.html").forward(request, response);
            return false;
        } else {

            return true;
        }
    }


}
