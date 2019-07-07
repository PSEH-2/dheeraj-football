package com.sapient.football.serviceimpl;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sapient.football.bo.ResponseJSON;
import com.sapient.football.service.LeagueServiceInterface;
import com.sapient.football.service.TeamServiceInterface;
import com.sapient.football.util.FootBallConstants;
import com.sapient.football.util.FootballUtil;

public class TeamServiceImpl implements TeamServiceInterface {

	private static final Logger LOGGER = LoggerFactory.getLogger(TeamServiceImpl.class);

	@Override
	public String getTeams(String leagueId, String apiKey) throws IOException {
		Map<String, String> queryParameters = new HashMap<>();
		queryParameters.put(FootBallConstants.API_KEY, apiKey);
		queryParameters.put(FootBallConstants.LEAGUE_ID_KEY, leagueId);
		queryParameters.put(FootBallConstants.ACTION_KEY, FootBallConstants.GET_TEAMS);
		return FootballUtil.callExternalAPI(queryParameters);
	}

	@Override
	public String getTeamId(String incomingTeamName, String leagueId, String apiKey, ResponseJSON responseJson)
			throws IOException {

		String responseBody = getTeams(leagueId, apiKey);
		String teamName = null;
		String teamId = null;
		JSONArray jsonarray = new JSONArray(responseBody);
		LOGGER.info("Total Teams are " + jsonarray.length());
		for (int i = 0; i < jsonarray.length(); i++) {
			JSONObject jsonobject = jsonarray.getJSONObject(i);
			teamName = jsonobject.getString("team_name");
			teamId = jsonobject.getString("team_key");
			if (teamName.equalsIgnoreCase(incomingTeamName)) {
				LOGGER.info("team id identified is " + teamId);
				responseJson.setTeamId(Integer.parseInt(teamId));
				responseJson.setTeamName(teamName);
				return teamId;
			}
		}
		return teamId;
	}

	@Override
	public String getOverallStandingCall(String leagueId, String apiKey) throws IOException {
		Map<String, String> queryParameters = new HashMap<>();
		queryParameters.put(FootBallConstants.API_KEY, apiKey);
		queryParameters.put(FootBallConstants.LEAGUE_ID_KEY, leagueId);
		queryParameters.put(FootBallConstants.ACTION_KEY, FootBallConstants.GET_STANDINGS);
		return FootballUtil.callExternalAPI(queryParameters);
	}

	@Override
	public String getOverallStanding(String incomingleagueId, String apiKey, ResponseJSON responseJson)
			throws IOException {

		String responseBody = getOverallStandingCall(incomingleagueId, apiKey);
		String leagueId = null;
		JSONArray jsonarray = new JSONArray(responseBody);
		LOGGER.info("Total Teams are " + jsonarray.length());
		for (int i = 0; i < jsonarray.length(); i++) {
			JSONObject jsonobject = jsonarray.getJSONObject(i);
			leagueId = jsonobject.getString("league_id");
			if (leagueId.equalsIgnoreCase(incomingleagueId)) {
				LOGGER.info("leagueId id identified is " + leagueId);
				responseJson.setOverallLeaguePosition(Integer.parseInt(leagueId));
				return leagueId;
			}
		}
		return leagueId;
	}

}
