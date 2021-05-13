package com.demo.atm.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.atm.entity.ATM;
import com.demo.atm.exception.ATMNotFoundException;
import com.demo.atm.tranformer.JsonResponseTransformer;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/atm")
@Api(description = "This end point is mainly used to do the Operations on ATMs")
public class ATMController {

	@Value("${atm.request.url}")
	String URL;

	HashMap<ATM, String> atmCacheMap = new HashMap<>();

	
	@ApiOperation(value = "This  end point is used to find all the ATMS which are available in the URL", produces = "application/json")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "The atm list is retrieved successfully"),
			@ApiResponse(code = 204, message = "No Content found") })
	@GetMapping(value = "/list")
	@Cacheable("/atms")

	public ResponseEntity<?> getAllATMS() throws InterruptedException {
		Set<ATM> atmData = atmCacheMap.keySet();
		if (atmData != null && !atmData.isEmpty()) {
			throw new ATMNotFoundException("No ATM data Found");
		}
		return ResponseEntity.ok(atmCacheMap.keySet());
	}

	@ApiOperation(value = "This  end point is used to find all the ATMS based on the city name", produces = "application/json")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "The atm list is retrieved  based on the city name successfully"),
			@ApiResponse(code = 204, message = "No Content found") })
	@GetMapping(value = "/byCity/{city}")
	@Cacheable("atmsByCity")
	public ResponseEntity<?> getATMSByCity(
			@ApiParam(name = "city", value = "it is used to filter the listofAtmsBy city") @PathVariable String city) {

		List<ATM> atmsList = new ArrayList<>();
		atmCacheMap.forEach((key, value) -> {
			if (value.equalsIgnoreCase(city))
				atmsList.add(key);

		});
		if (atmsList != null && !atmsList.isEmpty())
			return ResponseEntity.ok(atmsList);
		return ResponseEntity.noContent().build();
	}

	@GetMapping("list/CacheEvict")
	@CacheEvict("/atms")
	public String listAtmsCacheEvict() {
		return "Atms Cache list cleared Successfully";
	}

	@GetMapping("byCity/CacheEvict")
	@CacheEvict("atmsByCity")
	public String AtmsByCityCacheEvict() {
		return "Atms Cache list cleared Successfully";
	}
	
	
	
}
