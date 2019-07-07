package com.sapient.football.service;

import java.io.IOException;

import com.sapient.football.bo.ResponseJSON;

/*
 * Interface to be implemented by country service implementation class
 */
public interface CountryServiceInterface {
	public String getCountryList(String apiKey) throws IOException;
	
	public String getCountryId(String countryName, String apiKey, ResponseJSON responseObject) throws IOException;
}
