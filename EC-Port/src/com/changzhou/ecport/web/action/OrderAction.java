package com.changzhou.ecport.web.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Map;

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
import com.changzhou.ecport.entity.UserList;

public class OrderAction extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request,response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session=request.getSession(false);
		UserList users = (UserList) session.getAttribute("user");
		User user =users.getUserList();
		String name = user.getName();
		float cost=Float.parseFloat(request.getParameter("alltotle"));
		int payway =Integer.parseInt(request.getParameter("payway"));
		ServiceBiz getSer = ServiceBizFactory.getServ();
		int id = getSer.getMaxid();
		getSer.addOrders(id,cost, name, payway);
		ShopCartList prod = (ShopCartList) session.getAttribute("product");
		Map pro = prod.getCartList();
		Iterator it = pro.keySet().iterator();
		while(it.hasNext())
		  {
			 String ids = (String)it.next();
			 Product product =(Product) pro.get(ids);
			 getSer.addOrderLine(id, product.getId(), product.getAmount());
		   }
		ShopCartList cartlist = (ShopCartList) session.getAttribute("product");
		cartlist.clearAll();
		response.sendRedirect("../user/order.jsp");
	}
}
