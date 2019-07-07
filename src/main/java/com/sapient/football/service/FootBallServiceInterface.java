package com.sapient.football.service;

import java.io.IOException;

import com.sapient.football.bo.ResponseJSON;

public interface FootBallServiceInterface {
	
	public ResponseJSON getStandings(String countryName, String leagueName, String teamName, String apiKey ) throws IOException;

}
