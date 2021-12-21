package com.edison.snl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.edison.snl.model.Ladder;
import com.edison.snl.model.Player;
import com.edison.snl.model.Snake;

public class Driver {

	public Driver() {
		// TODO Auto-generated constructor stub
	}
	
	public static void playGame(List<Player> players, List<Snake> snakes, List<Ladder> ladders) {
		SnakeAndLadderService snakeAndLadderService = new SnakeAndLadderService();
		snakeAndLadderService.initialiseGame(players, snakes, ladders);
		snakeAndLadderService.startGame();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		
		int numberOfSnakes = scanner.nextInt();
		List<Snake> snakes = new ArrayList<Snake>();
		
		for(int i = 0 ; i < numberOfSnakes; i++) {
			snakes.add(new Snake(scanner.nextInt(), scanner.nextInt()));
		}
		
		int numberOfLadders = scanner.nextInt();
		List<Ladder> ladders = new ArrayList<Ladder>();
		
		for(int i = 0 ; i < numberOfLadders; i++) {
			ladders.add(new Ladder(scanner.nextInt(), scanner.nextInt()));
		}
		
		int numberOfPlayers = scanner.nextInt();
		List<Player> players = new ArrayList<Player>();
		for(int i = 0 ; i < numberOfPlayers; i++) {
			players.add(new Player(scanner.next()));
		}
		System.out.println("Inputs Received");
		
		System.out.println();
		
		String continuePlaying;
		do {
			playGame(players, snakes, ladders);
			System.out.println("Do you want to continue? ");
			continuePlaying = scanner.next();

		} while(continuePlaying.toLowerCase().equals("yes"));
		
		System.out.println("Game ends");
		
	}

}
