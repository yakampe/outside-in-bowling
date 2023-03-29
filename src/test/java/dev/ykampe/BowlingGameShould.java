package dev.ykampe;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class BowlingGameShould {

    private final static String INPUT_STRING = "X|7/|9-|X|-8|8/|-6|X|X|X||81";
    @Mock
    BowlingGameStringSplitter bowlingGameStringSplitter;

    @Mock
    BowlingGameFrameCalculator bowlingGameFrameCalculator;

    @Test
    void splitIncomingStringIntoFrames() {
        BowlingGame bowlingGame = new BowlingGame(bowlingGameStringSplitter, bowlingGameFrameCalculator);
        bowlingGame.playGame(INPUT_STRING);
        Mockito.verify(bowlingGameStringSplitter).processGameString(INPUT_STRING);
    }


    @Test
    void calculateScoreForFrame() {
        BowlingGame bowlingGame = new BowlingGame(bowlingGameStringSplitter, bowlingGameFrameCalculator);
        bowlingGame.playGame(INPUT_STRING);
        verify(bowlingGameFrameCalculator).calculateFrameScore(any());
    }




}