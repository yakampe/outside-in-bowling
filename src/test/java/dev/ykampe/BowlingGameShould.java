package dev.ykampe;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class BowlingGameShould {

    private final static String INPUT_STRING = "X|7/|9-|X|-8|8/|-6|X|X|X||81";
    @Mock
    BowlingGameStringSplitter bowlingGameStringSplitter;

    @Mock
    BowlingGameFrameCalculator bowlingGameFrameCalculator;

    BowlingGame bowlingGame;

    @BeforeEach
    public void setUp() {
        bowlingGame = new BowlingGame(bowlingGameStringSplitter, bowlingGameFrameCalculator);
    }

    @Test
    void splitIncomingStringIntoFrames() {
        when(bowlingGameStringSplitter.processGameString(anyString())).thenReturn(List.of(new BowlingFrame()));
        bowlingGame.playGame(INPUT_STRING);
        Mockito.verify(bowlingGameStringSplitter).processGameString(INPUT_STRING);
    }


    @Test
    void calculateScoreForFrame() {
        when(bowlingGameStringSplitter.processGameString(anyString())).thenReturn(List.of(new BowlingFrame()));
        bowlingGame.playGame(INPUT_STRING);
        verify(bowlingGameFrameCalculator).calculateFrameScore(any());
    }


    @Test
    void processAllFrames() {
        List<BowlingFrame> listOfFrames = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            listOfFrames.add(new BowlingFrame());
        }

        when(bowlingGameStringSplitter.processGameString(anyString())).thenReturn(listOfFrames);
        bowlingGame.playGame(INPUT_STRING);
        verify(bowlingGameFrameCalculator, times(10)).calculateFrameScore(any());
    }

    @Test
    void calculateTheSumOfAllFrameScores() {
        List<BowlingFrame> listOfFrames = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            listOfFrames.add(new BowlingFrame());
        }

        when(bowlingGameStringSplitter.processGameString(anyString())).thenReturn(listOfFrames);
        when(bowlingGameFrameCalculator.calculateFrameScore(any())).thenReturn(10);

        bowlingGame.playGame(INPUT_STRING);
        assertEquals(100, bowlingGame.score());
    }


}