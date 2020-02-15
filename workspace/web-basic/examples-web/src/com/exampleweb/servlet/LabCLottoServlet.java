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

@WebServlet("/lab-c-lotto.action") 
public class LabCLottoServlet extends HttpServlet { // 호출 규약 구현

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//데이터 처리
		//Lotto.java 파일의 selectGoldenNumbers 메서드와 관련 메서드를 사용해서 당첨예상번호 뽑기
		//뽑힌 번호는 배열 변수에 저장		
		Lotto lotto = new Lotto();
		int[] numbers = lotto.selectGoldenNumbers(); // 별도의 Lotto 객체의 메서드 호출
		
		//JSP에서 데이터를 사용하도록 request 객체에 데이터 저장
		//(forward 방식을 사용해서 JSP로 이동할 경우 request 객체를 공유하기 때문에 가능한 방법)
		request.setAttribute("numbers", numbers);
		
		//응답 컨텐츠 생성 -> JSP에서 처리하도록 forward
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher("jsp/lab-c-lotto.jsp");
		dispatcher.forward(request, response);

	}

}









