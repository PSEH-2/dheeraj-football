package com.sapient.football.bo;

import java.util.ArrayList;
import java.util.List;

public class TeamBO {
	String team_key;
	public String getTeam_key() {
		return team_key;
	}
	public void setTeam_key(String team_key) {
		this.team_key = team_key;
	}
	public String getTeam_name() {
		return team_name;
	}
	public void setTeam_name(String team_name) {
		this.team_name = team_name;
	}
	public String getTeam_badge() {
		return team_badge;
	}
	public void setTeam_badge(String team_badge) {
		this.team_badge = team_badge;
	}
	public List<PlayerBO> getPlayers() {
		return players;
	}
	public void setPlayers(List<PlayerBO> players) {
		this.players = players;
	}
	String team_name;
	String team_badge;
	List<PlayerBO> players = new ArrayList<>();
	
}
