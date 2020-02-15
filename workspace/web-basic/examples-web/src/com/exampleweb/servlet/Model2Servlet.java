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

@WebServlet("/model2.action") 
public class Model2Servlet extends HttpServlet { // 호출 규약 구현

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//데이터 처리
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 hh시 mm분 ss초");
		Date d = new Date();
		String dateString = sdf.format(d);//날짜를 지정된 형식의 문자열로 변환
		
		//JSP에서 데이터를 사용하도록 request 객체에 데이터 저장
		//(forward 방식을 사용해서 JSP로 이동할 경우 request 객체를 공유하기 때문에 가능한 방법)
		request.setAttribute("date", dateString);
		
		//응답 컨텐츠 생성 -> JSP에서 처리하도록 forward
		RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/05.model2.jsp");
		dispatcher.forward(request, response);

	}

}









