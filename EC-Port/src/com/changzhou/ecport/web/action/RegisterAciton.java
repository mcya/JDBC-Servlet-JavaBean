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
import com.changzhou.ecport.entity.User;

public class RegisterAciton extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(false);
		String name = request.getParameter("userid");
		String pwd = request.getParameter("password");
		String address1 = request.getParameter("address1");
		String address2 = request.getParameter("address2");
		String zip = request.getParameter("zip");
		String homephone = request.getParameter("homephone");
		String officephone = request.getParameter("officephone");
		String cellphone = request.getParameter("cellphone");
		String email = request.getParameter("email");
		
		User user = new User(name, pwd, address1, address2, zip, homephone,
				officephone, cellphone, email);
		ServiceBiz getSer = ServiceBizFactory.getServ();
		try {
			if (!getSer.IsUse(name)) {
				getSer.InsertUser(user);
				request.setAttribute("users", user);
//				response.sendRedirect("loginAction.do");
				request.getRequestDispatcher("loginAction.do").forward(request, response);
			}else{
				response.sendRedirect("../error.html");
			}
		} catch (RuntimeException e) {
			e.printStackTrace();
		}

	}

}
