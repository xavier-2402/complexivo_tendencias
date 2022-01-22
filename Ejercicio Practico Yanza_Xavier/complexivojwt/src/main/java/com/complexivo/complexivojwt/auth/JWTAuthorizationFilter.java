package com.complexivo.complexivojwt.auth;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;

public class JWTAuthorizationFilter extends OncePerRequestFilter{

    private final String HEADER = "Authorization";
    private final String PREFIX = "Bearer ";
    private final String SECRET = "clavesecreta";


    @Override
    protected void doFilterInternal(HttpServletRequest arg0, HttpServletResponse arg1, FilterChain chain)
            throws ServletException, IOException {
                try{
                    if(existeJWTToken(arg0,arg1)){

                        Claims claims = validarToken(arg0);
                        if(claims.get("authorities") != null){
                            setUpSpringAuthentication(claims); 
                        }
                        else{
                            SecurityContextHolder.clearContext();
                        }
                    }
                    else{
                        SecurityContextHolder.clearContext();
                    }
                    chain.doFilter(arg0, arg1);
                }
                catch(ExpiredJwtException | UnsupportedJwtException | MalformedJwtException e){
                    arg1.setStatus(HttpServletResponse.SC_FORBIDDEN);
                    ((HttpServletResponse) arg1).sendError(HttpServletResponse.SC_FORBIDDEN,e.getMessage());
                }
        
    }

    private boolean existeJWTToken(HttpServletRequest request, HttpServletResponse response){
        String authenticationHeader = request.getHeader(HEADER);
        if(authenticationHeader == null || !authenticationHeader.startsWith(PREFIX))
            return false;

        return true;   

    }

    public Claims validarToken(HttpServletRequest request){
        String jwtToken = request.getHeader(HEADER).replace(PREFIX, "");
        return Jwts.parser().setSigningKey(SECRET.getBytes()).parseClaimsJws(jwtToken).getBody();

    }

    private void setUpSpringAuthentication(Claims claims){

        List<String> authorities = (List) claims.get("authorities");
        UsernamePasswordAuthenticationToken auth = 
        new UsernamePasswordAuthenticationToken(claims.getSubject(),null,
        authorities.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList()));
        SecurityContextHolder.getContext().setAuthentication(auth);
    }   
    
}


