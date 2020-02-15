package com.exampleweb.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ex-currency.action") 
public class ExchangeCurrencyServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String usd = request.getParameter("usd");
		String cny = request.getParameter("cny");
		
		double result = 0;		
		if (usd == null) { //cny 169.50
			result = Integer.parseInt(cny) * 169.50;
		} else { //usd 1136.29
			result = Integer.parseInt(usd) * 1136.29;
		}
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<h2>RESULT : " + result + "</h2>");
		
	}

}
