package com.hsbc.exchangerate.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hsbc.exchangerate.model.ExchangeRateViewBean;

@Service
public interface InteExchangeRate {

	public List<ExchangeRateViewBean> getExchangeRates(String datetime);
	public List<ExchangeRateViewBean> getExchangeRates(String datetime,String base);
	public List<ExchangeRateViewBean> getExchangeRates();
	public List<ExchangeRateViewBean> getExchangeRates(String datetime,String base,String symbols);
}
