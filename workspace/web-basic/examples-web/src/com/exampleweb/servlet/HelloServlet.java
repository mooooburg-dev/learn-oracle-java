package com.exampleweb.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//hello.action 요청이 발생하면 HelloServlet을 찾으세요 (찾기 : 어떤 요청에 응답할 것인지 설정)
@WebServlet("/hello.action") 
public class HelloServlet extends HttpServlet { // 호출 규약 구현

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		//response.getWriter() -> PrintWriter : 네트워크로 응답 데이터 전송 (IO 객체)
		response.getWriter().append("<h1>")
							.append(new Date().toString() + " from instructor")
							.append("</h1>");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
