package com.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
/**
 * Created by Oliver.Liu on 3/5/2016.
 */
public class SecurityInterceptor implements HandlerInterceptor {

    private static final String LOGIN_URL = "/user/test";
    private static Logger logger  = Logger.getLogger(SecurityInterceptor.class);

    public boolean preHandle(HttpServletRequest req,
                             HttpServletResponse res,
                             Object handler) throws Exception {
        HttpSession session = req.getSession(true);
        // 从session 里面获取用户名的信息
        Object obj = session.getAttribute("");
        // 判断如果没有取到用户信息，就跳转到登陆页面，提示用户进行登陆
        if (obj == null || "".equals(obj.toString())) {
            //res.sendRedirect(LOGIN_URL);
        }
        logger.info("执行Action前先判断权限");
        return true;
    }
    @Override
    public void postHandle(HttpServletRequest req, HttpServletResponse res, Object arg2, ModelAndView arg3) throws Exception {
        //postHandle(req, res, arg2, arg3);
        //logger.info("生成视图前,可以改model和视图");
    }
    @Override
    public void afterCompletion(HttpServletRequest req, HttpServletResponse res, Object arg2, Exception arg3) throws Exception {
        //afterCompletion(req, res, arg2, arg3);
        //logger.info("生成视图前,可以改model和视图");
    }
}
