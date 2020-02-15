package com.helloexample.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/submit")
public class SubmitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// request.getParameter : 클라이언트(브라우저)에서 전송된 요청 데이터 읽기
		String data1 = request.getParameter("data1");
		String data2 = request.getParameter("data2");
		
		System.out.printf("GET : [%s][%s]\n", data1, data2);
		
		// 응답 컨텐츠의 종류(text/plain)와 인코딩(utf-8) 설정 -> 브라우저에게 알려주기
		response.setContentType("text/plain; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println(String.format("GET : [%s][%s]\n", data1, data2));
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 요청 데이터를 읽을 떄 적용할 인코딩 지정 (반드시 읽기 전에 호출)
		request.setCharacterEncoding("UTF-8");
		
		String data1 = request.getParameter("data1");
		String data2 = request.getParameter("data2");
		
		System.out.printf("POST : [%s][%s]\n", data1, data2);
		
		response.setContentType("text/plain; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println(String.format("POST : [%s][%s]\n", data1, data2));
	}

}
