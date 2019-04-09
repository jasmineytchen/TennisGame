package com.company;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class UmpireTest {

	Umpire u1 = new Umpire();

	@Test
	public void printScoreAtStartOfGame(){
		assertThat(u1.announceScore(), is("love love"));
	}

	@Test
	public void printScoreWhenPlayerOneScores(){
		u1.updatePlayerOneScore();
		assertThat(u1.announceScore(), is("fifteen love"));
		u1.updatePlayerOneScore();
		assertThat(u1.announceScore(), is("thirty love"));
	}

	@Test
	public void printScoreWhenPlayerTwoScores(){
		u1.updatePlayerOneScore();
		assertThat(u1.announceScore(), is("fifteen love"));
		u1.updatePlayerTwoScore();
		assertThat(u1.announceScore(), is("fifteen fifteen"));
	}

	@Test
	public void printScoreWhenPlayerOneWins(){
		u1.updatePlayerOneScore();
		u1.updatePlayerOneScore();
		u1.updatePlayerTwoScore();
		u1.updatePlayerOneScore();
		u1.updatePlayerOneScore();
		assertThat(u1.announceScore(), is("Game Player1"));
	}

	@Test
	public void printScoreWhenPlayerTwoWins(){
		u1.updatePlayerTwoScore();
		u1.updatePlayerTwoScore();
		u1.updatePlayerTwoScore();
		u1.updatePlayerTwoScore();
		assertThat(u1.announceScore(), is("Game Player2"));
	}

	@Test
	public void printScoreWhenPlayersAreDeuce(){
		u1.updatePlayerOneScore();
		u1.updatePlayerOneScore();
		u1.updatePlayerOneScore();
		u1.updatePlayerTwoScore();
		u1.updatePlayerTwoScore();
		u1.updatePlayerTwoScore();
		assertThat(u1.announceScore(), is("Deuce"));
	}

	@Test
	public void printScoreWhenPlayer1HasAdvantage(){
		u1.updatePlayerOneScore();
		u1.updatePlayerOneScore();
		u1.updatePlayerOneScore();
		u1.updatePlayerTwoScore();
		u1.updatePlayerTwoScore();
		u1.updatePlayerTwoScore();
		u1.updatePlayerOneScore();
		assertThat(u1.announceScore(), is("Advantage Player1"));
	}

	@Test
	public void printScoreWhenPlayer2HasAdvantage(){
		u1.updatePlayerOneScore();
		u1.updatePlayerOneScore();
		u1.updatePlayerOneScore();
		u1.updatePlayerTwoScore();
		u1.updatePlayerTwoScore();
		u1.updatePlayerTwoScore();
		u1.updatePlayerTwoScore();
		assertThat(u1.announceScore(), is("Advantage Player2"));
	}
//
//	@Test
//	public void scoreConverter(){
//		Umpire u1 = new Umpire(3, 3);
//		assertThat(u1.announceScore(), is("deuce"));
//	}

}