package com.example.springweb.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class DruidConfig {
    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druid() {
        return new DruidDataSource();
    }
    //配置Druid的监控
    //1、配置一个管理后台的Servlet
    @Bean
    public ServletRegistrationBean druidStatViewServlet() {
        ServletRegistrationBean bean=new ServletRegistrationBean(new StatViewServlet(),"/druid/*");
        Map<String,String> initParams=new HashMap<>();
        initParams.put("loginUsername","admin");  //登录后台时的用户名
        initParams.put("loginPassword","123456");  //登录后台时的密码
        initParams.put("allow","");  //允许谁登录,默认允许所有
        initParams.put("deny","192.168.0.101"); //拒绝谁访问
        bean.setInitParameters(initParams);
        return bean;
    }

    //2、配置一个监控的filter
    @Bean
    public FilterRegistrationBean webStatFilter() {
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(new WebStatFilter());
        Map<String,String> initParms=new HashMap<>();
        initParms.put("exclusions","*.js,*.css,/druid/*");  //告诉哪些可以不用拦截
        bean.setInitParameters(initParms);
        bean.setUrlPatterns(Arrays.asList("/*"));  //拦截哪些请求,拦截所有请求
        return bean;
    }
}
