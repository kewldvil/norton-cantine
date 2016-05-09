package com.cantine.app.configuration;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionConfig implements HttpSessionListener {
	   public void sessionCreated(HttpSessionEvent event) {
	        System.out.println("==== Session is created ====");
	        event.getSession().setMaxInactiveInterval(24*3600);
	    }
	 
	    public void sessionDestroyed(HttpSessionEvent event) {
	        System.out.println("==== Session is destroyed ====");
	    }
}
