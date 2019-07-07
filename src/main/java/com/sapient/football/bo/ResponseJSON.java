package com.sapient.football.bo;

/**
 * Class Representing response from football service
 * @author beta
 *
 */
public class ResponseJSON {
	private int countryId;
	private String countryName;
	private int leagueId;
	private String leagueName;
	private int teamId;
	private String teamName;
	private int overallLeaguePosition;

	public int getCountryId() {
		return countryId;
	}

	public void setCountryId(int countryId) {
		this.countryId = countryId;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public int getLeagueId() {
		return leagueId;
	}

	public void setLeagueId(int leagueId) {
		this.leagueId = leagueId;
	}

	public String getLeagueName() {
		return leagueName;
	}

	public void setLeagueName(String leagueName) {
		this.leagueName = leagueName;
	}

	public int getTeamId() {
		return teamId;
	}

	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public int getOverallLeaguePosition() {
		return overallLeaguePosition;
	}

	public void setOverallLeaguePosition(int overallLeaguePosition) {
		this.overallLeaguePosition = overallLeaguePosition;
	}

}
