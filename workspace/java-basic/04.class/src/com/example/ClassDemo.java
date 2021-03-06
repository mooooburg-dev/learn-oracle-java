package com.example;

import java.awt.Button;
import java.awt.Color;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;

public class ClassDemo {

	public static void main(String[] args) {
			
		// 윈도우를 만드는 객체
		JFrame window = new JFrame();
		
		// 윈도우가 닫히면 프로그램 종료
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setLayout(null);	// 윈도우의 하위 요소 위치를 직접 결정
		
		window.setTitle("윈도우 만들기 연습");
		window.setSize(500, 400);
		window.setResizable(false);
		
		// 윈도우의 사용자 화면 영역 객체
		Container panel = window.getContentPane();
		panel.setBackground(Color.orange);
		
		// 버튼 객체 만들기
		JButton button = new JButton();
		button.setText("눌러주세요");
		button.setSize(300, 100);
		button.setLocation(100, 125);
		window.add(button);
		
		window.setVisible(true);	
	}

}
