package com.springexample.springioc3;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sun.misc.FormattedFloatingDecimal.Form;

@Component("timeService")
public class MyTimeService implements TimeService {

	@Autowired
	//SimpleDateFormat : 날짜 데이터를 지정된 형식의 문자열로 변환
	SimpleDateFormat format;// = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");	
	public void setFormat(SimpleDateFormat format) {
		this.format = format;
	}

	public String getTimeString() {
		
		return format.format(new Date());
		
	}


	
	
}





