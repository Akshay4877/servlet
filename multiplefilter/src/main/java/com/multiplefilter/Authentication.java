package com.multiplefilter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class Authentication
 */
@WebFilter("/Authentication")
public class Authentication implements Filter {

	/**
	 * Default constructor. 
	 */
	public Authentication() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {

	}


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("dofilter method is called" +this.getClass().getName());
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse res = (HttpServletResponse)response;
		String UserName = req.getParameter("username");
		String Password = req.getParameter("password");


		if(!(UserName.equalsIgnoreCase("admin")&& Password.equals("admin")))
		{
			System.out.println("not accessed");
			res.sendRedirect("index.html");
		}
		chain.doFilter(request, response);
	}


	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("Init method is called" +this.getClass().getName());
	}

}
