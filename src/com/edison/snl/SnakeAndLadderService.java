package com.edison.snl;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.edison.snl.model.Ladder;
import com.edison.snl.model.Player;
import com.edison.snl.model.Snake;
import com.edison.snl.model.SnakeAndLadderBoard;

public class SnakeAndLadderService {

	private SnakeAndLadderBoard snakeAndLadderBoard;
	
	private Queue<Player> players;
	
	private int initialNumberOfPlayers;
	
	private Boolean isGameCompleted;
	
	private static final int DEFAULT_BOARD_SIZE = 100;
	
	public SnakeAndLadderService() {
		snakeAndLadderBoard = new SnakeAndLadderBoard(DEFAULT_BOARD_SIZE);
		
		players = new LinkedList<Player>();
		
		initialNumberOfPlayers = 0;
		
		isGameCompleted = false;
	}
	
	public void initialiseGame(List<Player> initialPlayers, List<Snake> snakes, List<Ladder> ladders) {
		initialNumberOfPlayers = players.size();

		players = new LinkedList<Player>();
		
		HashMap<String, Integer> playerPieces = new HashMap<String, Integer>();
		
		for(Player player : initialPlayers) {
			players.add(player);
			
			playerPieces.put(player.getId(), 0);
		}
		
		snakeAndLadderBoard = new SnakeAndLadderBoard(DEFAULT_BOARD_SIZE, snakes, ladders, playerPieces);
		
	}
	
	private void updateIsGameCompleted() {
		
		for(Player player : players) {
			if(snakeAndLadderBoard.getPlayerPieces().get(player.getId()) == snakeAndLadderBoard.getBoardSize()) {
				isGameCompleted = true;
				System.out.println(player.getPlayerName() + " Wins the game");
				return;
			}
		}
	}
	
	private int getNewPosition(int potentialNewPosition) {
		//Check for snakes and ladders recursively and give new position
		int newPosition = potentialNewPosition;
		
		int currentPosition;
		do {
			currentPosition = newPosition;
			for(Snake snake : snakeAndLadderBoard.getSnakes()) {
				if( snake.getStart() == currentPosition) {
					System.out.println("======= Got bitten by a snake ==========");
					newPosition = snake.getEnd();
				}
			}
			
			for(Ladder ladder : snakeAndLadderBoard.getLadders()) {
				if( ladder.getStart() == currentPosition) {
					System.out.println("======= Climbs the ladder ==========");
					newPosition = ladder.getEnd();
				}
			}	
			
		} while (currentPosition != newPosition);
		
		return newPosition;
	}
	
	private void movePlayer(Player currentPlayer) {
		
		int currentPosition = snakeAndLadderBoard.getPlayerPieces().get(currentPlayer.getId());
		
		int diceRollValue = DiceService.roll();
		
		int potentialNewPosition = currentPosition + diceRollValue;
		
		//Do nothing if the user goes out of the board
		if(potentialNewPosition <= snakeAndLadderBoard.getBoardSize()) {
			int newPosition = getNewPosition(potentialNewPosition);
			snakeAndLadderBoard.getPlayerPieces().put(currentPlayer.getId(), newPosition);
		}
		
		System.out.println(currentPlayer.getPlayerName() + " rolled a " + diceRollValue + " and moved from "
				+ currentPosition + " to " + snakeAndLadderBoard.getPlayerPieces().get(currentPlayer.getId()));
	}
	
	public void startGame() {
		
		while(!isGameCompleted) {
			
			Player currentPlayer = players.poll();
			
			movePlayer(currentPlayer);
			
			players.add(currentPlayer);
			
			updateIsGameCompleted();
			
		}
	}
	
	

}
