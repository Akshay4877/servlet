package com.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;


@WebListener
public class MyHttpSessionListener implements HttpSessionListener {

   
    public MyHttpSessionListener() {
        
    }

	
    public void sessionCreated(HttpSessionEvent httpSessionEvent)  { 
    	System.out.println("session created method" +this.getClass().getName());
    	HttpSession session  = httpSessionEvent.getSession();
    	
    	System.out.println(session  + "session created");
    	System.out.println("ID=" + session.getId() + "MaxInactiveInterval" + session.getMaxInactiveInterval());
    	
    	
    }

	
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent)  { 
    	System.out.println("session destroyed method" +this.getClass().getName());
    	HttpSession session  = httpSessionEvent.getSession();
    	
    	System.out.println(session  + "session destroyed");
    	System.out.println("ID=" + session.getId() + "MaxInactiveInterval" + session.getMaxInactiveInterval());
    	    
    }
	
}
