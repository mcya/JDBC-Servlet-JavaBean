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
import com.changzhou.ecport.entity.Product;

public class FindByName extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		ServiceBiz getSer = ServiceBizFactory.getServ();
		String name = request.getParameter("find");
//		List pro=getSer.findByName(name);
		System.out.println(name);
//		System.out.println(pro+"  1");
//		request.setAttribute("pro", pro);
		request.getRequestDispatcher("../result.jsp").forward(request, response);
	}

}
