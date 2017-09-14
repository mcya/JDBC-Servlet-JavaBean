package com.changzhou.ecport.web.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.*;
import javax.servlet.http.*;

import com.changzhou.ecport.entity.User;
import com.changzhou.ecport.entity.UserList;

public class LoginFilter implements Filter {
	public void doFilter(HttpServletRequest request, HttpServletResponse response,
			FilterChain chain) throws java.io.IOException, ServletException {

		HttpSession session = request.getSession(false);
	    if(session == null)
	    {
	      response.sendRedirect("../login.html");
	    }
	    UserList users = (UserList) session.getAttribute("user");
		User user=null;
		try {
			user = users.getUserList();
		} catch (RuntimeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//	    System.out.println(user);
	    if(user == null)
	    {
	      response.sendRedirect("../login.html");
	      return;
	    }
	   
	    chain.doFilter(request, response);
	}

	public void destroy() {

	}

	public void init(FilterConfig arg0) throws ServletException {

	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		doFilter((HttpServletRequest)request, (HttpServletResponse)response, chain);
	}

}
