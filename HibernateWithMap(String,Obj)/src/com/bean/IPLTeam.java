package com.bean;

import java.util.Map;

public class IPLTeam {
	private int tid;
	private String ownerName,teamName;
	private Map<String , Player> players;
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public Map<String, Player> getPlayers() {
		return players;
	}
	public void setPlayers(Map<String, Player> players) {
		this.players = players;
	}
	
}
