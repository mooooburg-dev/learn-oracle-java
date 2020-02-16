package com.springexample.springioc4;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sun.misc.FormattedFloatingDecimal.Form;

public class MyTimeService implements TimeService {

	SimpleDateFormat format;// = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");	
	public void setFormat(SimpleDateFormat format) {
		this.format = format;
	}

	public String getTimeString() {
		
		return format.format(new Date());
		
	}


	
	
}





