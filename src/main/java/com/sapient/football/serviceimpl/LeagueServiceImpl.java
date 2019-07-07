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
import com.sapient.football.util.FootBallConstants;
import com.sapient.football.util.FootballUtil;

public class LeagueServiceImpl implements LeagueServiceInterface {

	private static final Logger LOGGER = LoggerFactory.getLogger(LeagueServiceInterface.class);

	@Override
	public String getLeagues(String countryid, String apiKey) throws IOException {
		Map<String, String> queryParameters = new HashMap<>();
		queryParameters.put(FootBallConstants.API_KEY, apiKey);
		queryParameters.put(FootBallConstants.COUNTRY_ID_KEY, countryid);
		queryParameters.put(FootBallConstants.ACTION_KEY, FootBallConstants.GET_LEAGUES);
		return FootballUtil.callExternalAPI(queryParameters);
	}

	@Override
	public String getLeagueId(String incomingLeagueName, String countryId, String apiKey, ResponseJSON responseJson)
			throws IOException {

		String responseBody = getLeagues(countryId, apiKey);
		String leagueName = null;
		String leagueId = null;
		JSONArray jsonarray = new JSONArray(responseBody);
		LOGGER.info("Total Leagues are " + jsonarray.length());
		for (int i = 0; i < jsonarray.length(); i++) {
			JSONObject jsonobject = jsonarray.getJSONObject(i);
			leagueName = jsonobject.getString("league_name");
			leagueId = jsonobject.getString("league_id");
			if (leagueName.equalsIgnoreCase(incomingLeagueName)) {
				LOGGER.info("league id identified is " + leagueId);
				responseJson.setLeagueId(Integer.parseInt(leagueId));
				responseJson.setLeagueName(leagueName);
				return leagueId;
			}
		}
		return leagueId;
	}

}

/*
 * 
 * String country_id; String country_name; String league_id; String league_name;
 * String league_season;
 */