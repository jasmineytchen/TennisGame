package com.company;

public class Player {

	int score = 0;
	int name;

	public int getPlayerScore() { return score; }

	public int updatePlayerScore() {
		return this.score++;
	}

	public String scoreAgainst(Player player) {

		int scoreDifference = this.score - player.score;

		if (scoreDifference == 0) {
			return "Deuce";
		} else if (scoreDifference == 1) {
			return "Advantage";
		} else if (scoreDifference >= 2) {
			return "Game";
		} else {
			return "Score cannot be negative";
		}
	}
}