package com.java.springBoot_jwt_demo.security;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

/*
* JWTAuthenticationFilter that extends OncePerRequestFilter and override method and write the logic to check the token that is sent in header.
* We have to write 5 important logic

    -Get Token from request
    -Validate Token
    -GetUsername from token
    -Load user associated with this token
    -set authentication
* */

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private Logger logger = LoggerFactory.getLogger(OncePerRequestFilter.class);
    @Autowired
    private JwtHelper jwtHelper;
    
    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
    	System.out.println("Inside JwtAuthenticationFilter: doFilterInternal Service......");
    	String requestHeader = request.getHeader("Authorization");
        logger.info(" Header :  {}", requestHeader);
        String username = null;
        String token = null;
        if (requestHeader != null && requestHeader.startsWith("Bearer")) {
            token = requestHeader.substring(7);
            try {
                //Fetching the username passed in the JWT token
                username = this.jwtHelper.getUsernameFromToken(token);
            } catch (IllegalArgumentException e) {
                logger.info("Illegal Argument while fetching the username !!");
                request.setAttribute("errorMessage","Illegal Argument while fetching the username !!");
                e.printStackTrace();
            } catch (ExpiredJwtException e) {
                logger.info("Given jwt token has expired !!");
                request.setAttribute("errorMessage","Given JWT has expired !!");
                e.printStackTrace();
            } catch (MalformedJwtException e) {
                logger.info("JWT token has been Malformed!! Invalid Token");
                request.setAttribute("errorMessage","JWT token has been Malformed!! Invalid Token");
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            logger.info("Invalid Header Value !! ");
        }
        /*  In Spring Security, the SecurityContextHolder is a holder for the security context of the current thread.
         *  It is a central point of access for the security information associated with the current thread of execution.
         *  The security context typically includes details about the currently authenticated principal (user), such as their username, roles, 
         *  and other authentication-related information.*/
        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            //fetch user-detail by the username.
            UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);
            Boolean validateToken = this.jwtHelper.validateToken(token, userDetails);
            if (validateToken) {
                //set the authentication
                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authentication);
            } else {
                logger.info("Validation failed! Bad credentials");
                request.setAttribute("errorMessage","Validation failed! Bad credentials");
            }
        }
        filterChain.doFilter(request, response);
    }
}
