package org.openpaas.paasta.portal.web.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication // =>@Configuratio,@EnableAutoConfiguration,@ComponentScan 3개의 어노테이션을 묶어놓은것
//@EnableDiscoveryClient
public class WebAdminApplication extends WebMvcConfigurerAdapter {
    public static void main(String[] args) {
        SpringApplication.run(WebAdminApplication.class, args);
    }

}
