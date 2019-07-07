package com.sapient.football.bo;

/**
 * Class representing Input JSON for football service
 * 
 * @author beta
 *
 */
public class InputJSON {
	private String countryName;
	private String leagueName;
	private String teamName;

	public InputJSON() {

	}

	public InputJSON(String countryName, String leagueName, String teamName) {
		super();
		this.countryName = countryName;
		this.leagueName = leagueName;
		this.teamName = teamName;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getLeagueName() {
		return leagueName;
	}

	public void setLeagueName(String leagueName) {
		this.leagueName = leagueName;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

}
