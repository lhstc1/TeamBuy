package cs2020.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan({"cs2020.controller","cs2020.config"})
@EnableWebMvc
public class SpringMvcConfig {
}
