package com.exampleweb.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/el-jstl-test.action") 
public class ELJSTLServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("req_data", "Hello, EL from Request " + Math.random());
		HttpSession session = request.getSession();
		session.setAttribute("sess_data", "Hello, EL from Session " + Math.random());
		
		DepartmentVO dp = new DepartmentVO();
		dp.setDepartmentId((int)(Math.random() * 900) + 100);
		dp.setDepartmentName("Dept. " + dp.getDepartmentId());
		request.setAttribute("dp", dp);
		
		ArrayList al = new ArrayList();
		al.add(dp);
		al.add("Simple Text");
		request.setAttribute("al", al);
		
		RequestDispatcher d = request.getRequestDispatcher("/jsp/08.el-jstl-result.jsp");
		d.forward(request, response);
		
	}

}





