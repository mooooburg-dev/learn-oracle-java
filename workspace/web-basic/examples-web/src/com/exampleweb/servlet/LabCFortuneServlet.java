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

@WebServlet("/lab-c-fortune.action") 
public class LabCFortuneServlet extends HttpServlet { // 호출 규약 구현

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//데이터 처리
		String[] messages = new String[10]; //이 변수는 다른 스크립트릿 영역에서 사용할 수 있습니다.
		for (int i = 0; i < messages.length; i++) {
			messages[i] = "행운 메시지 " + (i + 1);
		}
		int r = (int)(Math.random() * 10);
		String message = messages[r];
		
		//JSP에서 데이터를 사용하도록 request 객체에 데이터 저장
		//(forward 방식을 사용해서 JSP로 이동할 경우 request 객체를 공유하기 때문에 가능한 방법)
		request.setAttribute("message", message);
		
		//응답 컨텐츠 생성 -> JSP에서 처리하도록 forward
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher("jsp/lab-c-fortune.jsp");
		dispatcher.forward(request, response);

	}

}









