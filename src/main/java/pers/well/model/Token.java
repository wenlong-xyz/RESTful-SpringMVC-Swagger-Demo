package pers.well.model;

import java.util.Calendar;
import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;
import pers.well.util.Constants;


public class Token {
	String token;
	@JSONField(format = "yyyy-MM-dd HH:mm")
	Date activeDate;

	public Token(String token) {
		super();
		this.token = token;
		Calendar ca=Calendar.getInstance();
		ca.setTime(new Date());
		ca.add(Calendar.HOUR_OF_DAY, Constants.ACTIVE_HOURS);
		this.activeDate = ca.getTime();
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public Date getActiveDate() {
		return activeDate;
	}
	public void setActiveDate(Date activeDate) {
		this.activeDate = activeDate;
	}
	
	

}
