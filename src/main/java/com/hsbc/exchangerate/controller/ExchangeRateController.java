package com.hsbc.exchangerate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hsbc.exchangerate.model.ExchangeRateViewBean;
import com.hsbc.exchangerate.service.InteExchangeRate;

import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping("/")
public class ExchangeRateController {

	@Autowired
	InteExchangeRate exchangeRateService;
	List<ExchangeRateViewBean> exchangerateList = null;

	@RequestMapping("/")
	@ApiOperation (value ="get default list of exchange rates")
	public String viewHomePage(Model model) {

		exchangerateList = exchangeRateService.getExchangeRates();
		model.addAttribute("exchangerateList", exchangerateList);
		return "welcome";
	}
	
	@RequestMapping("/exchangerates")
	public String viewExchangeRatePage(Model model) {

		exchangerateList = exchangeRateService.getExchangeRates();

		model.addAttribute("exchangerateList", exchangerateList);

		return "welcome";
	}


	@RequestMapping("/exchangerates/{datetime}")
	public String viewExchangeRatePage(@PathVariable String datetime, Model model) {

		exchangerateList = exchangeRateService.getExchangeRates(datetime);

		model.addAttribute("exchangerateList", exchangerateList);

		return "welcome";
	}

	@RequestMapping("/exchangerates/{datetime}/{base}")
	public String viewExchangeRatePage(@PathVariable String datetime, @PathVariable String base, Model model) {

		exchangerateList = exchangeRateService.getExchangeRates(datetime, base);

		model.addAttribute("exchangerateList", exchangerateList);

		return "welcome";
	}

	@RequestMapping("/exchangerates/{datetime}/{base}/{symbols}")
	public String viewExchangeRatePage(@PathVariable String datetime, @PathVariable String base, @PathVariable String symbols,
			Model model) {

		exchangerateList = exchangeRateService.getExchangeRates(datetime, base, symbols);

		model.addAttribute("exchangerateList", exchangerateList);

		return "welcome";
	}

}
