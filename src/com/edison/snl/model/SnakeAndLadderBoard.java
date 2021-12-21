package com.edison.snl.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SnakeAndLadderBoard {

	private int size;
	
	private List<Snake> snakes;
	
	private List<Ladder> ladders;
	
	private Map<String, Integer> playerPieces;
	
	public SnakeAndLadderBoard() {
		// TODO Auto-generated constructor stub
	}
	
	public SnakeAndLadderBoard(int size) {
		this.size = size;
		this.snakes = new ArrayList<Snake>();
		this.ladders = new ArrayList<Ladder>();
		this.playerPieces = new HashMap<String, Integer>();
	}

	public SnakeAndLadderBoard(int boardSize, List<Snake> snakes, List<Ladder> ladders,
			Map<String, Integer> playerPieces) {
		this.size = boardSize;
		this.snakes = snakes;
		this.ladders = ladders;
		this.playerPieces = playerPieces;
	}

	public int getBoardSize() {
		return size;
	}

	public void setBoardSize(int boardSize) {
		this.size = boardSize;
	}

	public List<Snake> getSnakes() {
		return snakes;
	}

	public void setSnakes(List<Snake> snakes) {
		this.snakes = snakes;
	}

	public List<Ladder> getLadders() {
		return ladders;
	}

	public void setLadders(List<Ladder> ladders) {
		this.ladders = ladders;
	}

	public Map<String, Integer> getPlayerPieces() {
		return playerPieces;
	}

	public void setPlayerPieces(Map<String, Integer> playerPieces) {
		this.playerPieces = playerPieces;
	}

	
}
