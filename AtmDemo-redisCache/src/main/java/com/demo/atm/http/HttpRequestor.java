package com.demo.atm.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpRequestor {

	public static String getResponse(String URL) throws IOException {

		try {
			String response_string = null;
			StringBuilder response = new StringBuilder();
			URL url = new URL(URL);
			HttpURLConnection httpconn = (HttpURLConnection) url.openConnection();

			if (httpconn.getResponseCode() == HttpURLConnection.HTTP_OK) {
				BufferedReader input = new BufferedReader(new InputStreamReader(httpconn.getInputStream()));
				String strLine = null;
				while ((strLine = input.readLine()) != null) {
					response.append(strLine);
				}
				input.close();
				response_string = response.toString();
			}

			httpconn.disconnect();

			return response_string;
		} catch (Exception e) {
			throw new IOException();
		}

	}

}