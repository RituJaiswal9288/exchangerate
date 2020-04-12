package com.hsbc.exchangerate.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import com.hsbc.exchangerate.model.CurrencyBean;
import com.hsbc.exchangerate.model.ExchangeRateViewBean;


@Repository
public class ExchangeRateRepositary {

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	HttpHeaders headers;
	
	String dateStr=null;
	

	List<ExchangeRateViewBean> exchangerateList = null;
	ExchangeRateViewBean exchangeRateViewBean = null;

	public List<ExchangeRateViewBean> getExchangeRates(String datetime,String base,String symbols) {
		
		exchangerateList = new ArrayList<ExchangeRateViewBean>();
		
		if(datetime == null)datetime="latest";

		if(base == null)base="EUR";

		String url=getUrl(datetime, base, symbols);
		

		CurrencyBean obj=getObj(url);
		if(obj != null)
		{
		Map<String, Object> rates = obj.getRates();
		
		for (Entry<String, Object> entry : rates.entrySet()) {
			if (symbols != null && symbols.contains(entry.getKey())) {
				exchangeRateViewBean = new ExchangeRateViewBean();
				exchangeRateViewBean.setCurrency(entry.getKey());
				exchangeRateViewBean.setExchangerate(entry.getValue().toString());
				exchangerateList.add(exchangeRateViewBean);
			}else
			{
				exchangeRateViewBean = new ExchangeRateViewBean();
				exchangeRateViewBean.setCurrency(entry.getKey());
				exchangeRateViewBean.setExchangerate(entry.getValue().toString());
				exchangerateList.add(exchangeRateViewBean);
			}
		}
		
		
		dateStr=obj.getDate();
		
		LocalDate latest = LocalDate.parse(dateStr);
		for(int i=1 ; i < 6 ;i++)
		{
			LocalDate earlier = latest.minusMonths(i);
			getPastdata(earlier.toString(),base,symbols,i);	
		}		
		}

		return exchangerateList;
	}

	
	public String getUrl(String datetime, String base,String symbols)
	{
		String url = "https://api.ratesapi.io/api/" + datetime.trim();
		
		if(base != null && symbols != null)
		{
			url+="?base="+base.trim().toUpperCase()+"&symbols="+symbols.trim().toUpperCase();
		}else if(base == null && symbols != null)
		{
			url+="?symbols="+symbols.toUpperCase().trim();	
		}else if(base != null && symbols == null)
		{
			url+="?base="+base.trim().toUpperCase();	
		}
		return url;
	}
	
	public CurrencyBean getObj(String url)
	{
		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
		ResponseEntity<CurrencyBean> res = restTemplate.exchange(url, HttpMethod.GET, entity, CurrencyBean.class);

		CurrencyBean obj = res.getBody();
		return obj;
	}
	
	
	public void getPastdata(String earlierDate,String base,String symbols,int i)
	{
		String url=getUrl(earlierDate, base, symbols);
		CurrencyBean obj=getObj(url);
		
		if(obj != null)
		{
		Map<String, Object> rates1 = obj.getRates();
		
		for (Entry<String, Object> entry1 : rates1.entrySet())
		{
			
			ExchangeRateViewBean exchangeRateViewBean=exchangerateList.stream().filter(a -> a.getCurrency().equalsIgnoreCase(entry1.getKey()))
			.findAny().orElse(null);
			
			//System.out.println(exchangeRateViewBean.getCurrency());
			//System.out.println(exchangeRateViewBean.getExchangerate());
			if(exchangeRateViewBean != null)
			{
			if(i == 1)
			{
			exchangeRateViewBean.setExchangerate1(entry1.getValue().toString());
			}else if(i == 2)
			{

				exchangeRateViewBean.setExchangerate2(entry1.getValue().toString());	
			}else if(i == 3)
			{

				exchangeRateViewBean.setExchangerate3(entry1.getValue().toString());
			}else if(i == 4)
			{

				exchangeRateViewBean.setExchangerate4(entry1.getValue().toString());
			}else if(i == 5)
			{

				exchangeRateViewBean.setExchangerate5(entry1.getValue().toString());
			}
			}
		}
		}
	}
}
