package com.multiplefilter;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

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
		System.out.println("destroy filter method is called" +this.getClass().getName());
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("do filter method is called" +this.getClass().getName());
		PrintWriter out = response.getWriter();
		HttpServletRequest request1 = (HttpServletRequest)request;
		String ipAddress = request1.getRemoteAddr();
		System.out.println("IP" + ipAddress +"Time " +new Date().toString());
		out.println("Logfilter is invoked before<br>");
		chain.doFilter(request1, response);
		//out.println("log filter is invoked after<br>");
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("Init method is called" +this.getClass().getName());
	}

}
