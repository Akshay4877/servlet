package com.listener;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/HttpSessionTestServlet")
public class HttpSessionTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	public void init(ServletConfig config) throws ServletException {
		System.out.println("Init method is called " +this.getClass().getName());
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	response.setContentType("text/html");	
	sleep();
	HttpSession httpSession = request.getSession();
	sleep();
	httpSession.invalidate();
	
	}


	private void sleep() {
		try
		{
			Thread.sleep(12000);
		}
		catch(InterruptedException e)
		{
			e.printStackTrace();
		}
		
	}

}
