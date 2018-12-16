package com.gmail.stepan1983.Config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class WebInitializer implements WebApplicationInitializer {


    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext context =
                new AnnotationConfigWebApplicationContext();
        context.register(AppConfig.class);
        context.setServletContext(servletContext);

        ServletRegistration.Dynamic servlet =
                servletContext.addServlet("dispather",
                        new DispatcherServlet(context));
        servlet.addMapping("/");
        servlet.setLoadOnStartup(1);


    }
}
