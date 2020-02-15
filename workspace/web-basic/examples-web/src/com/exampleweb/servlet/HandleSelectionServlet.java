package com.exampleweb.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/handle-selection.action") 
public class HandleSelectionServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//request.setCharacterEncoding("utf-8");
		
		String gender = request.getParameter("gender");
		// 값이 여럿인 전송 데이터는 getParameterValues로 읽어야 합니다. (배열 반환)
		String[] hobbies = request.getParameterValues("hobby"); 
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.append("<h2>")
		   .append("[" + gender + "]");
		for (String hobby : hobbies) {
			out.append("[" + hobby + "]");
		}
		out.append("</h2>");
		
	}

}
