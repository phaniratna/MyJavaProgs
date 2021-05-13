package com.demo.atm.entity;

import java.io.Serializable;
import java.util.List;

public class OpeningHours implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer dayOfWeek;
	private List<Hours> hours;
	public Integer getDayOfWeek() {
		return dayOfWeek;
	}
	public void setDayOfWeek(Integer dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}
	public List<Hours> getHours() {
		return hours;
	}
	public void setHours(List<Hours> hours) {
		this.hours = hours;
	}
	@Override
	public String toString() {
		return "OpeningHours [dayOfWeek=" + dayOfWeek + ", hours=" + hours + "]";
	}
	

}
