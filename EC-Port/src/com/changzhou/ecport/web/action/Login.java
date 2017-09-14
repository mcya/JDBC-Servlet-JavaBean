package com.changzhou.ecport.web.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.changzhou.ecport.biz.ServiceBiz;
import com.changzhou.ecport.biz.ServiceBizFactory;
import com.changzhou.ecport.entity.Product;
import com.changzhou.ecport.entity.User;
import com.changzhou.ecport.entity.UserList;

public class Login extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		doPost(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name=null;
		String pwd=null;
		HttpSession session = request.getSession(true);
		UserList user=(UserList) session.getAttribute("user");
		if(session!=null){
			name=request.getParameter("userid");
			pwd=request.getParameter("password");
		}else{
			User usersd=(User) request.getAttribute("user");
			name=usersd.getName();
			pwd=usersd.getPwd();
		}
		
		ServiceBiz getSer = ServiceBizFactory.getServ();
		User users=getSer.IsLogin(name, pwd);
//		users=getSer.IsLogin(name, pwd);
		if(user==null){
			response.sendRedirect("../login.html");
		}
		if(users==null){
				response.sendRedirect("../login.html");
			
		}else{
			user.add(users);
			response.sendRedirect("../index.jsp");
//			request.getRequestDispatcher("ViewUser.do").forward(request, response);
		}
	}

}
