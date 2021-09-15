package com.example.filters;


import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.web.OAuth2LoginAuthenticationFilter;

@Configuration
public class configurer {
    @Bean
    public FilterRegistrationBean<SigninSignupFilter> signinSignupBean() {
        final FilterRegistrationBean filterRegBean = new FilterRegistrationBean();
        filterRegBean.setFilter(new SigninSignupFilter());
        // todo : should be executed when OAuth2LoginAuthenticationFilter.DEFAULT_FILTER_PROCESSES_URI is requested instead of "/user"
        filterRegBean.addUrlPatterns("/user");
        filterRegBean.setEnabled(Boolean.TRUE);
        filterRegBean.setName("SigninSignup Filter");
        return filterRegBean;
    }
}
