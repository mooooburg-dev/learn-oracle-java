package com.demoweb.vo.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;


@WebListener
public class DemowebListener implements ServletContextListener, HttpSessionListener {

	// 각 사용자(브라우저) 단위로 session이 만들어질 때 호출
    public void sessionCreated(HttpSessionEvent se)  {
    	ServletContext application = se.getSession().getServletContext();
    	int current = (int)application.getAttribute("current");
    	int total = (int)application.getAttribute("total");
    	application.setAttribute("current", current + 1);
    	application.setAttribute("total", total + 1);
    }

    // 각 사용자(브라우저) 단위로 session이 제거될 때 호출
    public void sessionDestroyed(HttpSessionEvent se)  {
    	ServletContext application = se.getSession().getServletContext();
    	int current = (int)application.getAttribute("current");
    	application.setAttribute("current", current - 1);
    }

	// 서버가 종료될 때 호출
    public void contextDestroyed(ServletContextEvent sce)  {
    	System.out.println("서버가 종료됩니다.");
    }

    // 서버가 시작될 때 호출
    public void contextInitialized(ServletContextEvent sce)  {
    	ServletContext application = sce.getServletContext();
    	application.setAttribute("current", 0);
    	application.setAttribute("total", 0);
    }
	
}
