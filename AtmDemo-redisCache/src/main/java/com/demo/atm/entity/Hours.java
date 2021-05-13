package com.demo.atm.entity;

import java.io.Serializable;

public class Hours  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String hourFrom;
	private String hourTo;
	public String getHourFrom() {
		return hourFrom;
	}
	public void setHourFrom(String hourFrom) {
		this.hourFrom = hourFrom;
	}
	public String getHourTo() {
		return hourTo;
	}
	public void setHourTo(String hourTo) {
		this.hourTo = hourTo;
	}
	@Override
	public String toString() {
		return "Hours [hourFrom=" + hourFrom + ", hourTo=" + hourTo + "]";
	}


}
