package com.changzhou.ecport.web.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.changzhou.ecport.entity.User;
import com.changzhou.ecport.entity.UserList;

public class UserListener implements HttpSessionListener{
	UserList user=new UserList();
	
	public void sessionCreated(HttpSessionEvent request) {
		request.getSession().setAttribute("user", user);
	}

	public void sessionDestroyed(HttpSessionEvent request) {
	}

}
