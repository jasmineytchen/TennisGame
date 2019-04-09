package com.company;

import java.util.HashMap;

public class Umpire {

	private final Player player1 = new Player();
	private final Player player2 = new Player();
	private HashMap<Integer, String> scoreConverter = new HashMap<Integer, String>() {{
		put(0, "love");
		put(1, "fifteen");
		put(2, "thirty");
		put(3, "forty");
	}};


	public String announceScore() {

		if (this.player1.getPlayerScore() >= 3){
			int scoreDifferences = this.player1.getPlayerScore() - this.player2.getPlayerScore();
			return convertScoreToString(scoreDifferences);
		}

		if (this.player2.getPlayerScore() >= 3){
			int scoreDifferences = this.player2.getPlayerScore() - this.player1.getPlayerScore();
			return convertScoreToString(scoreDifferences);
		}

		return convertScore(this.player1.getPlayerScore())+ " " + convertScore(this.player2.getPlayerScore());
	}

	private String convertScoreToString(int scoreDifferences) {
		if (scoreDifferences == 0){
			return "Deuce";
		} else if (scoreDifferences == 1){
			return "Advantage";
		} else if (scoreDifferences >= 2){
			return "Game";
		}
		return null;
	}


	private String convertScore(int score){
		return scoreConverter.get(score);
	}

	public int updatePlayerOneScore() {
		return player1.updatePlayerScore();
	}

	public int updatePlayerTwoScore() {
		return player2.updatePlayerScore();
	}
}
