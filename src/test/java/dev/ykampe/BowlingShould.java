package dev.ykampe;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BowlingShould {


    @Test
    void process_whole_game_and_return_correct_score() {
        //arrange
        String inputString = "X|7/|9-|X|-8|8/|-6|X|X|X||81";

        BowlingGamePipeStringSplitter bowlingGamePipeStringSplitter = new BowlingGamePipeStringSplitter();

        BowlingGame bowlingGame = new BowlingGame(bowlingGamePipeStringSplitter);

        //act
        bowlingGame.playGame(inputString);

        //assert
        assertEquals(167, bowlingGame.score());
    }
}