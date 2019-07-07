package com.sapient.football.serviceimpl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sapient.football.bo.CountryBO;
import com.sapient.football.bo.ResponseJSON;
import com.sapient.football.service.CountryServiceInterface;
import com.sapient.football.util.FootBallConstants;
import com.sapient.football.util.FootballUtil;

public class CountryServiceImpl implements CountryServiceInterface {

	private static final Logger LOGGER = LoggerFactory.getLogger(CountryServiceImpl.class);

	@Override
	public String getCountryList(String apiKey) throws IOException {
		Map<String, String> queryParameters = new HashMap<>();
		queryParameters.put(FootBallConstants.API_KEY, apiKey);
		queryParameters.put(FootBallConstants.ACTION_KEY, FootBallConstants.GET_COUNTRIES);
		return FootballUtil.callExternalAPI(queryParameters);
	}

	@Override
	public String getCountryId(String incomingcountryName, String apiKey, ResponseJSON responseJson) throws IOException {
		String responseBody = getCountryList(apiKey);
		String countryName = null;
		String countryId = null;
		JSONArray jsonarray = new JSONArray(responseBody);
		LOGGER.info("Total Countries are " + jsonarray.length());
		for (int i = 0; i < jsonarray.length(); i++) {
			JSONObject jsonobject = jsonarray.getJSONObject(i);
			countryName = jsonobject.getString("country_name");
			countryId = jsonobject.getString("country_id");
			if (countryName.equalsIgnoreCase(incomingcountryName)) {
				LOGGER.info("country id identified is " + countryId);
				responseJson.setCountryId(Integer.parseInt(countryId));
				responseJson.setCountryName(countryName);
				return countryId;
			}
		}
		return countryId;

	}

}
