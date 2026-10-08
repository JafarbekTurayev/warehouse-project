package com.example.warehouseapp.security;

import com.example.warehouseapp.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtFilter extends OncePerRequestFilter {

    @Autowired
    JwtProvider jwtProvider;

    @Autowired
    AuthService myAuthService;


    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {

        String token = httpServletRequest.getHeader("Authorization");
        if (token != null && token.startsWith("Bearer ")) {
            token = token.substring(7);
            boolean validateToken = jwtProvider.validateToken(token);
            if (validateToken) {
                String username = jwtProvider.getUsernameFromToken(token);

                try {
                    UserDetails userDetails = myAuthService.loadUserByUsername(username);

                    UsernamePasswordAuthenticationToken passwordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());

                    SecurityContextHolder.getContext().setAuthentication(passwordAuthenticationToken);
                } catch (UsernameNotFoundException ignored) {
                    // token egasi o'chirilgan bo'lsa, so'rov anonim davom etadi
                }
            }
        }
        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }
}
