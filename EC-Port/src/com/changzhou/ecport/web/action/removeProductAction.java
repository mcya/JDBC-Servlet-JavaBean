package com.changzhou.ecport.web.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.changzhou.ecport.entity.ShopCartList;

public class removeProductAction extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(false);
		ShopCartList prod=(ShopCartList) session.getAttribute("product");
		String proid = request.getParameter("productid");
		prod.removeProduct(proid);
		request.getRequestDispatcher("ViewShoppingAction.do").forward(request,response);
	}

}
