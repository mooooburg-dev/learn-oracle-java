package com.exampleweb.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

//확장자가 jsp인 모든 요청에 대해 이 필터를 사용하세요
@WebFilter("*.jsp")
public class ExampleWebFilter implements Filter {

    public ExampleWebFilter() { }

	public void init(FilterConfig fConfig) throws ServletException { }

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest)request;
		
		System.out.println(req.getRequestURI());// 현재 요청의 경로 문자열을 출력
		
		chain.doFilter(request, response); //다음 필터 또는 서블릿 또는 JSP로 이동하는 명령
	}
	
	public void destroy() { }



}
