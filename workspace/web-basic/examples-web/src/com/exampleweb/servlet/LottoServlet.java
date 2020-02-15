package com.exampleweb.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//lotto.action 요청이 발생하면 HelloServlet을 찾으세요 (찾기 : 어떤 요청에 응답할 것인지 설정)
@WebServlet("/lotto.action") 
public class LottoServlet extends HttpServlet { // 호출 규약 구현

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.append("<h3>당첨 예상 번호</h3>");
		out.append("<h3>");
		for (int i = 0; i < 6; i++) {
			int number = (int)(Math.random() * 45) + 1;
			out.append("[" + number  + "]");		
		}
		out.append("</h3>");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
