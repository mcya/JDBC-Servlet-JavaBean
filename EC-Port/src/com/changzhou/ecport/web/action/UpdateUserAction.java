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
import com.changzhou.ecport.entity.UserList;

public class UpdateUserAction extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		String pwd =request.getParameter("password");
		UserList usersd = (UserList) session.getAttribute("user");
		ServiceBiz getSer = ServiceBizFactory.getServ();
		User user =usersd.getUserList();
		User users=getSer.IsLogin(user.getName(), user.getPwd());
		users.setName(request.getParameter("userid"));
		users.setPwd(pwd);
		users.setAddress1(request.getParameter("address1"));
		users.setAddress2(request.getParameter("address2"));
		users.setZipcode(request.getParameter("zip"));
		users.setHostPhone(request.getParameter("homephone"));
		users.setOfficePhone(request.getParameter("officephone"));
		users.setMobile(request.getParameter("cellphone"));
		users.setEmail(request.getParameter("email"));
		getSer.UpdateUser(users);
		usersd.add(users);
		response.sendRedirect("../index.jsp");
	}
		
}

