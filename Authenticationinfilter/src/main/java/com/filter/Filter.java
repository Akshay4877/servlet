package com.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class Filter
 */
@WebFilter("/Filter")
public class Filter implements javax.servlet.Filter {

   
    public Filter() {
       
    }

	
	public void destroy() {
		
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		 PrintWriter out=response.getWriter();  
         
		    String password=request.getParameter("password");  
		    
		    if(password.equals("admin"))
		    {  
		    chain.doFilter(request, response);//sends request to next resource  
		    }  
		    else
		    {  
		    out.print("username or password error!");  
		   //RequestDispatcher rd=request.getRequestDispatcher("index.html");  
		    //rd.include(request, response);  
		    }  
		          
		}  
		    
		  
	
	

	
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
