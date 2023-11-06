package com.example.university.pl.config.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JWTProvider jwtProvider;

    public JwtAuthenticationFilter(JWTProvider jwtProvider) {
        this.jwtProvider = jwtProvider;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        //1. extraire token
        String token = jwtProvider.extractToken(request);
        //2. valider le token
        if(token!= null && jwtProvider.validateToken(token)) {
            //3. recuperer l'user du token
            //4. créer Authentication user
            Authentication authentication = jwtProvider.createAuthentication(token);
            //5. placer l'authentication dans le SecurityContextHolder
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
        //6. renvoyer vers la suite des filtres
        filterChain.doFilter(request,response);
    }
}
