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
import com.changzhou.ecport.entity.ShopCartList;
import com.changzhou.ecport.entity.User;

public class UpdateProductAction extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(false);
		ShopCartList prod=(ShopCartList) session.getAttribute("product");
		int proid = Integer.parseInt(request.getParameter("productid"));
		int amount = Integer.parseInt(request.getParameter("num"));
		prod.changeProduct(proid, amount);
		request.getRequestDispatcher("ViewShoppingAction.do").forward(request,response);
	}
}
