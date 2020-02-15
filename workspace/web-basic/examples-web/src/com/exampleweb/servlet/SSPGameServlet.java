package com.exampleweb.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ssp-game.action") 
public class SSPGameServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		String ssp = request.getParameter("ssp");		
		String ssp2 = String.valueOf( (int)(Math.random() * 3) + 1 ); //숫자 -> 문자열		
		String result = "";
		if (ssp.equals(ssp2)) {
			result = "비겼습니다";
		} else if ( (ssp.equals("1") && ssp2.equals("3")) || 
					(ssp.equals("2") && ssp2.equals("1")) ||
					(ssp.equals("3") && ssp2.equals("2"))) {
			result = "이겼습니다";
		} else {
			result = "졌습니다";
		}
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<h2>RESULT : " + result + "</h2>");
		
	}

}
