package com.church.Management_System.jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.*;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.church.Management_System.service.UserService;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

	@Component
	public class JwtFilter extends OncePerRequestFilter {

	    @Autowired
	    private JwtUtil jwtUtil;
	    @Autowired
	    private UserService userService;

	    @Override
	    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
	            throws ServletException, IOException {

	        String header = request.getHeader("Authorization");
	        String token = null;
	        String username = null;

	        if (header != null && header.startsWith("Bearer ")) {
	            token = header.substring(7);
	            username = jwtUtil.extractUsername(token);
	        }

	        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
	            var userDetails = userService.loadUserByUsername(username);

	            if (jwtUtil.validateToken(token, userDetails.getUsername())) {
	                UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(
	                        userDetails, null, userDetails.getAuthorities());

	                auth.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
	                SecurityContextHolder.getContext().setAuthentication(auth);
	            }
	        }

	        chain.doFilter(request, response);
	    }
	}

