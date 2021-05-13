package com.demo.atm.tranformer;

import java.io.IOException;

import com.demo.atm.entity.ATM;
import com.demo.atm.http.HttpRequestor;
import com.google.gson.Gson;

public class JsonResponseTransformer {

	public static ATM[] fromResponsetoArray(String URL) throws IOException {
		String response = HttpRequestor.getResponse(URL);
		String mainResponse = response.substring(5, response.length());
		ATM[] atmArray = null;
		try {
			atmArray = new Gson().fromJson(mainResponse, ATM[].class);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return atmArray;

	}

}
