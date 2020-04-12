package com.hsbc.exchangerate;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ExchangerateApplication {


	public static void main(String[] args) {
		SpringApplication.run(ExchangerateApplication.class, args);
	}

	
	@Bean
	public RestTemplate getRestTemplate()
	{
		return new RestTemplate();
	}
	
	@Bean
	public HttpHeaders getHttpHeaders()
	{
		
		HttpHeaders	headers=new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.ALL));
		headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:74.0) Gecko/20100101 Firefox/74.0");
		
		return headers;
	}
}
