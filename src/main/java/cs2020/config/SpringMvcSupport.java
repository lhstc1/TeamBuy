package cs2020.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import cs2020.controller.interceptor.ProjectInterceptor;
import cs2020.controller.interceptor.ProjectInterceptor2;

@Configuration
public class SpringMvcSupport extends WebMvcConfigurationSupport {
    @Autowired
    private ProjectInterceptor projectInterceptor;

    @Autowired
    private ProjectInterceptor2 projectInterceptor2;

    //设置静态资源访问过滤，当前类需要设置为配置类，并被扫描加载
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        //当访问/pages/????时候，从/pages目录下查找内容
        registry.addResourceHandler("/webpage/**").addResourceLocations("/webpage/");
        registry.addResourceHandler("/js/**").addResourceLocations("/js/");
    }

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(projectInterceptor).addPathPatterns("/webpage/Member.html");
        registry.addInterceptor(projectInterceptor2).addPathPatterns("/webpage/Loginin.html");
    }
}
