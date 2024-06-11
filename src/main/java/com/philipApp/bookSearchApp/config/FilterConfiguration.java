package com.philipApp.bookSearchApp.config;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class FilterConfiguration implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        response.setHeader("Access-Control-Allow-Headers","Content-Type, Authorization, Content-Length, X-Requested-With");
        response.setHeader("Access-Control-Allow-Origin","*");
        response.setHeader("Access-Control-Allow-Methods","POST, GET, PUT, PATCH,Option");
        response.setHeader("Access-Control-Allow-Credentials","true");


        if(request.getMethod().equalsIgnoreCase("Option")) {
            response.setStatus(HttpServletResponse.SC_ACCEPTED);
        }
        else{
            filterChain.doFilter(request,response);
        }
    }

    @Override
    public void destroy() {

    }
}