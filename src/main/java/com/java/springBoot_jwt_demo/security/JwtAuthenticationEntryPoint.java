package com.java.springBoot_jwt_demo.security;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.PrintWriter;

@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {

    //Method of this class is called whenever as exception is thrown due to unauthenticated user trying to access the resource that required authentication.
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException, IOException {
    	System.out.println("Inside JwtAuthenticationEntryPoint: commence Service......");
    	System.out.println("JwtAuthenticationEntryPoint : Unauthorized access");
    	response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        PrintWriter writer = response.getWriter();
        writer.println("Access Denied !! " +request.getAttribute("errorMessage"));
    }
}
