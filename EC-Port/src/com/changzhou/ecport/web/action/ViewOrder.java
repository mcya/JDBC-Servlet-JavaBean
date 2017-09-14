package com.changzhou.ecport.web.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.changzhou.ecport.biz.ServiceBiz;
import com.changzhou.ecport.biz.ServiceBizFactory;
import com.changzhou.ecport.entity.User;
import com.changzhou.ecport.entity.UserList;

public class ViewOrder extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(true);
		
		ServiceBiz getSer = ServiceBizFactory.getServ();
		String name = request.getParameter("oid");
		List proOrder = getSer.getProOrder(name);
		request.setAttribute("ord", proOrder);
		String pay = getSer.getPay(name);
		request.setAttribute("pay", pay);
		request.getRequestDispatcher("../user/orderinfo.jsp").forward(request, response);
		
	}

}
