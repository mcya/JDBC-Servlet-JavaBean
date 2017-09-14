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
import com.changzhou.ecport.entity.ShopCartList;

public class AddShopping extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session=request.getSession(false);
		ShopCartList pro = (ShopCartList) session.getAttribute("product");
		String productid = request.getParameter("productid");
		ServiceBiz getSer = ServiceBizFactory.getServ();
		Product prod=getSer.ShowProInfoById(productid);
		
		pro.addCart(prod);
		request.getRequestDispatcher("ViewShoppingAction.do").forward(request,response);
		
		
	}

}
