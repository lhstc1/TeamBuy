package cs2020.controller.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class ProjectInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String user = (String) request.getSession().getAttribute("user");
        System.out.println(user);
        if (null == user) {
            response.sendRedirect(request.getContextPath() + "/webpage/Login.html");
            return false;
        }
        System.out.println("preHandle...");
        return true;
    }
}
