package com.sapient.football.controller;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.football.bo.ResponseJSON;
import com.sapient.football.service.FootBallServiceInterface;
import com.sapient.football.serviceimpl.FootballServiceImpl;

@RestController
public class FootballController {

	private static final Logger LOGGER = LoggerFactory.getLogger(FootballController.class);

	@RequestMapping("/v1/search")
	public ResponseJSON getCountries(@RequestParam("countryName") String countryName,
			@RequestParam("leagueName") String leagueName, @RequestParam("teamName") String teamName,
			@RequestParam("apiKey") String apiKey) {

		LOGGER.info(countryName + " " + leagueName + " " + teamName);

		FootBallServiceInterface footBallService = new FootballServiceImpl();
		try {
			return footBallService.getStandings(countryName, leagueName, teamName, apiKey);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

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
