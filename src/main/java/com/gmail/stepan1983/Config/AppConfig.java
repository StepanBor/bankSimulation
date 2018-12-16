package com.gmail.stepan1983.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

import javax.sql.DataSource;
import java.util.Properties;

@EnableWebMvc
@Configuration
@ComponentScan("com.gmail.stepan1983")
public class AppConfig {


    @Bean
    public DataSource dataSource() {

        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/bank?serverTimezone=UTC");
        dataSource.setUsername("root");
        dataSource.setPassword("1979");

        return dataSource;
    }

    @Bean
    public JpaVendorAdapter jpaVendorAdapter() {

        HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();

        jpaVendorAdapter.setShowSql(true);
        jpaVendorAdapter.setGenerateDdl(true);
        jpaVendorAdapter.setDatabasePlatform("org.hibernate.dialect.MySQL5Dialect");

        return jpaVendorAdapter;

    }

    @Bean
    public LocalContainerEntityManagerFactoryBean
    entityManagerFactory(DataSource dataSource, JpaVendorAdapter jpaVendorAdapter) {

        /* https://docs.spring.io/spring-boot/docs/current/reference/html/howto-data-access.html
        Use a Traditional persistence.xml File

        Spring Boot will not search for or use a META-INF/persistence.xml by default.
        If you prefer to use a traditional persistence.xml,
        you need to define your own @Bean of type LocalEntityManagerFactoryBean
        (with an ID of ‘entityManagerFactory’) and set the persistence unit name there.*/

        Properties properties = new Properties();

        properties.setProperty("hibernate.hbm2ddl.auto", "create-drop");
        properties.setProperty("hibernate.format_sql", "true");

        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
//        factoryBean.setPersistenceUnitName("Bank");
//        factoryBean.setPersistenceXmlLocation("classpath:META-INF/persistence.xml");
        factoryBean.setDataSource(dataSource);
        factoryBean.setJpaVendorAdapter(jpaVendorAdapter);
        factoryBean.setJpaProperties(properties);
        factoryBean.setPackagesToScan("com.gmail.stepan1983");

        return factoryBean;

    }


    @Bean
    public UrlBasedViewResolver viewResolver() {


        UrlBasedViewResolver viewResolver = new UrlBasedViewResolver();
        viewResolver.setPrefix("/WEB-INF/JSP/");
        viewResolver.setSuffix(".jsp");
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setOrder(1);
        return viewResolver;

    }

}
