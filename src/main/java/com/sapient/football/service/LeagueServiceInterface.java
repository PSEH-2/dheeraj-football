package com.sapient.football.service;

import java.io.IOException;

import com.sapient.football.bo.ResponseJSON;

public interface LeagueServiceInterface {

	public String getLeagues(String countryId, String apiKey) throws IOException;
	
	public String getLeagueId(String leagueName, String countryId, String apiKey, ResponseJSON responseObject) throws IOException;

}
