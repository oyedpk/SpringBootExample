package com.rest.example.restexample;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;


@Component
public class SimpleFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println(servletRequest.getRemoteAddr());
        System.out.println(servletRequest.getRemoteHost());
        System.out.println(servletRequest.getRemotePort());
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
