package com.sapient.football.service;

import java.io.IOException;

import com.sapient.football.bo.ResponseJSON;

public interface TeamServiceInterface {
	public String getTeams(String leagueId, String apiKey) throws IOException;

	public String getTeamId(String teamName, String leagueId, String apiKey, ResponseJSON responseObject) throws IOException;

	public String getOverallStanding(String leagueId, String apiKey, ResponseJSON responseObject) throws IOException;

	String getOverallStandingCall(String leagueId, String apiKey) throws IOException;
}
