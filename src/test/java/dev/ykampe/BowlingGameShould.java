package dev.ykampe;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class BowlingGameShould {

    @Mock
    BowlingGameStringSplitter bowlingGameStringSplitter;

    @Mock
    BowlingGameFrameCalculator bowlingGameFrameCalculator;

    @Test
    void splitIncomingStringIntoFrames() {
        BowlingGame bowlingGame = new BowlingGame(bowlingGameStringSplitter, bowlingGameFrameCalculator);

        bowlingGame.playGame("X|7/|9-|X|-8|8/|-6|X|X|X||81");

        Mockito.verify(bowlingGameStringSplitter).processGameString("X|7/|9-|X|-8|8/|-6|X|X|X||81");
    }


    @Test
    void calculateScoreForFrame() {
        BowlingGame bowlingGame = new BowlingGame(bowlingGameStringSplitter, bowlingGameFrameCalculator);

        bowlingGame.playGame("X|7/|9-|X|-8|8/|-6|X|X|X||81");

        verify(bowlingGameFrameCalculator).calculateFrameScore(any());
    }




}