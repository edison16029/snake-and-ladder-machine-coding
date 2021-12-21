package com.edison.snl;

import java.util.Random;

public class DiceService {

	public DiceService() {
		// TODO Auto-generated constructor stub
	}
	
	public static int roll() {
		return new Random().nextInt(6) + 1;
	}

}
