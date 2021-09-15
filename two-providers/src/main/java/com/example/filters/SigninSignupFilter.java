package com.example.filters;

import com.example.models.User;
import com.example.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.client.web.OAuth2LoginAuthenticationFilter;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Component;

import org.springframework.web.filter.GenericFilterBean;
import javax.servlet.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Date;

//@WebFilter(filterName = OAuth2LoginAuthenticationFilter.DEFAULT_FILTER_PROCESSES_URI)
public class SigninSignupFilter extends GenericFilterBean {

    @Autowired
    private UserService userService;
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        OAuth2User principal = ((OAuth2AuthenticationToken) authentication).getPrincipal();
        User user = new User(principal.getAttribute("fullname"),
                             principal.getAttribute("email"),
                             principal.getAttribute("locale"),
                             new Date());
        userService.update(user);
        chain.doFilter(request, response);
    }

}
