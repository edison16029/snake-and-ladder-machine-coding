package com.edison.snl.model;

import java.util.UUID;

public class Player {

	private String name;
	
	private String id;
	
	public Player() {
		// TODO Auto-generated constructor stub
	}

	public Player(String playerName) {
		this.name = playerName;
		this.id = UUID.randomUUID().toString();
	}

	public String getPlayerName() {
		return name;
	}

	public void setPlayerName(String playerName) {
		this.name = playerName;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
