package com.hsbc.exchangerate.standalone;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.objectweb.asm.TypeReference;
import org.springframework.boot.json.JsonParser;
import org.springframework.boot.json.JsonParserFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hsbc.exchangerate.dao.ExchangeRateRepositary;
import com.hsbc.exchangerate.model.CurrencyBean;
import com.hsbc.exchangerate.model.ExchangeRateViewBean;

public class Testing {

	public static void main(String[] args) {

	/*	String url = "http://api.ratesapi.io/api/latest";

		RestTemplate restTemplate = new RestTemplate();

		HttpHeaders headers = new HttpHeaders();

		headers.setAccept(Arrays.asList(MediaType.TEXT_HTML));
		headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:74.0) Gecko/20100101 Firefox/74.0");
		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
		
		ResponseEntity<CurrencyBean> res = restTemplate.exchange(url, HttpMethod.GET, entity, CurrencyBean.class);
		
		CurrencyBean obj=res.getBody();
		Map<String,Object> rates=obj.getRates();
		

		 for (Entry<String, Object> entry : rates.entrySet())
		 {
	            System.out.println("Key = " + entry.getKey() + 
	                             ", Value = " + entry.getValue()); 
		 }*/
		
	//	List<ExchangeRateViewBean> list= new ExchangeRateRepositary().getExchangeRates("latest",null,null);
		
	}

}
