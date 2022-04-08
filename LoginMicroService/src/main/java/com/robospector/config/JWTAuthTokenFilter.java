package com.robospector.config;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

// A filter is an object that performs filtering tasks on either the
// request toa resource (a servlet or static content), or on the response
// from a resource,or both.
@RestController
public class JWTAuthTokenFilter implements Filter {
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request; // Send request JWT token throw HttpHeaders
		HttpServletResponse resp = (HttpServletResponse) response;
		String headerToken = req.getHeader("Authorization");
		
		try {
			
			if(req.getMethod().equals("OPTIONS")) {
				resp.setStatus(HttpStatus.OK.value());
				chain.doFilter(request, response);
			} else if(headerToken == null || !headerToken.startsWith("Bearer ")) {
				// resp.sendRedirect("/unauthorized"); // I can also return immediatly after this
				throw new Exception(); // ---------------------------------------------- J,
			}
			
			// Parse JWT token
			String jwtToken = headerToken.split(" ")[1];
			System.out.println("<----------------" + jwtToken);
			
			
			// parseClaimsJwt ---- is to alim only the payload. i.e the entity
			// parseClaimeJws ---- is to get the signature. ie: contains the header, the payload and the secret key
			Claims claims = Jwts.parser().setSigningKey("cgiStackroute")
			.parseClaimsJws(jwtToken)
			.getBody();
			
			req.setAttribute("claim", claims);
			chain.doFilter(request, response);
		} catch (Exception e) {
			resp.sendRedirect("/unauthorized");
		}
		
	}
	
	@GetMapping("/unauthorized")
	public String errorMessage() {
		return "Access denied - invalid token";
	}
}
