package com.changzhou.ecport.web.listener;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.changzhou.ecport.entity.Product;
import com.changzhou.ecport.entity.ShopCartList;

public class ShoppingCartListener implements HttpSessionListener{
	ShopCartList pro = new ShopCartList();
	
	public void sessionCreated(HttpSessionEvent request) {
		request.getSession().setAttribute("product", pro);
	}

	public void sessionDestroyed(HttpSessionEvent arg0) {
		
	}

}
