package com.demo.atm.controller;

import java.io.IOException;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.atm.entity.ATM;
import com.demo.atm.service.ATMService;
import com.demo.atm.tranformer.JsonResponseTransformer;

@RestController()
@RequestMapping("/atmredis")
public class ATMRedisController {
	private static final Logger log = LoggerFactory.getLogger(ATMRedisController.class);
	
	@Value("${atm.request.url}")
	String URL;
	

	@Autowired
	private ATMService atmService;
	
	
	@PostConstruct
	public void postConstruct() {
		ATM[] atmArray = null;
		try {
			atmArray = JsonResponseTransformer.fromResponsetoArray(URL);
			for (ATM atm : atmArray) {
				atmService.save(atm);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	@GetMapping("/list")
	public Set<ATM> getAll() {
		log.info("Welcome to the service");
		return atmService.getAll();

	}

}
