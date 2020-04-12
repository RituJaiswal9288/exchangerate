package com.hsbc.exchangerate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hsbc.exchangerate.dao.ExchangeRateRepositary;
import com.hsbc.exchangerate.model.ExchangeRateViewBean;

@Service
public class ExchangeRateService implements InteExchangeRate {

	@Autowired
	ExchangeRateRepositary exchangeRateRepositary;
	
	List<ExchangeRateViewBean> exchangerateList = null;

	@Override
	public List<ExchangeRateViewBean> getExchangeRates(String datetime, String base, String symbols) {
		// TODO Auto-generated method stub
		exchangerateList=exchangeRateRepositary.getExchangeRates(datetime, base, symbols);
		return exchangerateList;
	}

	@Override
	public List<ExchangeRateViewBean> getExchangeRates(String datetime) {
		// TODO Auto-generated method stub
		exchangerateList=exchangeRateRepositary.getExchangeRates(datetime, null, null);
		return exchangerateList;
	}

	@Override
	public List<ExchangeRateViewBean> getExchangeRates(String datetime, String base) {
		// TODO Auto-generated method stub
		exchangerateList=exchangeRateRepositary.getExchangeRates(datetime, base, null);
		return exchangerateList;
	}

	@Override
	public List<ExchangeRateViewBean> getExchangeRates() {
		// TODO Auto-generated method stub
		exchangerateList=exchangeRateRepositary.getExchangeRates(null, null, null);
		return exchangerateList;
	}
	
	
	

}
