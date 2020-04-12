package com.hsbc.exchangerate.model;

import java.util.LinkedHashMap;

public class CurrencyBean {
	
	private LinkedHashMap rates;
	private String date;
	private String base;
	public LinkedHashMap getRates() {
		return rates;
	}
	public void setRates(LinkedHashMap rates) {
		this.rates = rates;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getBase() {
		return base;
	}
	public void setBase(String base) {
		this.base = base;
	}
	


}
