package edu.neu.filter;

import java.io.IOException;
import java.util.Map;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpStatus;
import org.springframework.web.filter.GenericFilterBean;
import org.springframework.web.servlet.HandlerMapping;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import edu.neu.exception.InvalidTokenException;
import edu.neu.exception.PersonErrorInformation;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureException;

public class JwtFilter extends GenericFilterBean {

    @Override
    public void doFilter(final ServletRequest req,
                         final ServletResponse res,
                         final FilterChain chain) throws IOException, ServletException {
        final HttpServletRequest request = (HttpServletRequest) req;
        String path = ((HttpServletRequest) request).getRequestURI();
        // if the api end point corresponds to the login or the
        // register than it wont contain the auth token so 
        // just continue with the end point as normal 
        if (path.contains("login") || path.contains("register")) {
        	chain.doFilter(req, res);
        } else {
        	final String authHeader = request.getHeader("Authorization");
        	if (authHeader == null || !authHeader.startsWith("Bearer ")) {
                    throw new InvalidTokenException("Missing or invalid Authorization header.");
             }
            final String token = authHeader.substring(7); // The part after "Bearer "
            try {
                final Claims claims = Jwts.parser().setSigningKey("secretkey")
                    .parseClaimsJws(token).getBody();
                request.setAttribute("emailAddress", claims);
                chain.doFilter(req, res);
            }
            catch (Exception e) {
            	e.setStackTrace(new StackTraceElement[0]);
            	HttpServletResponse response = (HttpServletResponse) res;
            	response.setStatus(500);
            	response.getWriter().write(convertObjectToJson(e));
            }
        }
        
    }
    
    public String convertObjectToJson(Object object) throws JsonProcessingException {
        if (object == null) {
            return null;
        }
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(object);
    }

}
