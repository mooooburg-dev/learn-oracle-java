package com.exampleweb.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.exampleweb.service.Lotto;

@WebServlet("/lab-c-login.action") 
public class LabCLoginServlet extends HttpServlet { // 호출 규약 구현

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//데이터 처리
		//1. 전송된 id, passwd 읽기
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");
		boolean valid = id.equals("user") && passwd.equals("pwd");
		
		//JSP에서 데이터를 사용하도록 request 객체에 데이터 저장
		//(forward 방식을 사용해서 JSP로 이동할 경우 request 객체를 공유하기 때문에 가능한 방법)
		request.setAttribute("valid", valid);
		
		//응답 컨텐츠 생성 -> JSP에서 처리하도록 forward
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher("jsp/lab-c-login.jsp");
		dispatcher.forward(request, response);

	}

}









