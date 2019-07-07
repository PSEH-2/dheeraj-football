package com.sapient.football.serviceimpl;

import java.io.IOException;

import com.sapient.football.bo.ResponseJSON;
import com.sapient.football.service.CountryServiceInterface;
import com.sapient.football.service.FootBallServiceInterface;
import com.sapient.football.service.LeagueServiceInterface;
import com.sapient.football.service.TeamServiceInterface;

public class FootballServiceImpl implements FootBallServiceInterface {

	CountryServiceInterface countryService = new CountryServiceImpl();

	LeagueServiceInterface leagueService = new LeagueServiceImpl();

	TeamServiceInterface teamService = new TeamServiceImpl();

	@Override
	public ResponseJSON getStandings(String countryName, String leagueName, String teamName, String apiKey)
			throws IOException {
		ResponseJSON responseObject = new ResponseJSON();
		String countryId = countryService.getCountryId(countryName, apiKey, responseObject);
		String leagueId = leagueService.getLeagueId(leagueName, countryId, apiKey, responseObject);
		String teamId = teamService.getTeamId(teamName, leagueId, apiKey, responseObject);
		String overallStanding = teamService.getOverallStanding(leagueId, apiKey,responseObject);
		return responseObject;
	}

}

/*
 * https://apiv2.apifootball.com/?action=get_countries&APIkey=xxxxxxxxxxxxxx
 * Will return list of countries
 * 
 * https://apiv2.apifootball.com/?action=get_leagues&country_id=41&APIkey=
 * xxxxxxxxxxxxxx takes country id and return response having league Id
 * 
 * https://apiv2.apifootball.com/?action=get_teams&league_id=148&APIkey=
 * xxxxxxxxxxxxxx Takes leagueId and return response having data
 */
