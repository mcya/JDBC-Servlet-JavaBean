package com.changzhou.ecport.web.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.changzhou.ecport.entity.ShopCartList;
import com.changzhou.ecport.entity.UserList;

public class ExitAction extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request,response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(false);
//		session.removeAttribute("user");
		UserList user=(UserList) session.getAttribute("user");
		user.removeUser();
		ShopCartList cartlist = (ShopCartList) session.getAttribute("product");
		cartlist.clearAll();
		response.sendRedirect("../index.jsp");
	}

}
