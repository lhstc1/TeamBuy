package cs2020.controller.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class ProjectInterceptor2 implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String leader = (String) request.getSession().getAttribute("leader");
        System.out.println(leader);
        if (null == leader) {
            response.sendRedirect(request.getContextPath() + "/webpage/Login.html");
            return false;
        }
        System.out.println("preHandle...");
        return true;
    }
}
