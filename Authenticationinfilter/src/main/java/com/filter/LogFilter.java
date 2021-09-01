package com.filter;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.logging.Logger;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;


@WebFilter("/LogFilter")
public class LogFilter implements Filter {

   
    public LogFilter() {
        
    }

	
	public void destroy() {
		
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		Logger log = Logger.getAnonymousLogger();
		log.info("do filter method is called" +this.getClass().getName());
		PrintWriter out = response.getWriter();
		HttpServletRequest request1 = (HttpServletRequest)request;
		String ipAddress = request1.getRemoteAddr();
		log.info("IP" + ipAddress +"Time " +new Date().toString());
		out.println("Logfilter is invoked before<br>");
		out.println("IP" + ipAddress +"Time " +new Date().toString()+"<br>");
		chain.doFilter(request1, response);
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
