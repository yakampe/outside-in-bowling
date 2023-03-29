package dev.ykampe;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BowlingGamePipeStringSplitterTest {

    @Test
    void givenTenFrames__ShouldReturnAListOfTenFrameObjects() {
        BowlingGamePipeStringSplitter bowlingGamePipeStringSplitter = new BowlingGamePipeStringSplitter();

        List<BowlingFrame> actual = bowlingGamePipeStringSplitter.processGameString("X|7/|9-|X|-8|8/|-6|X|X|9");

        assertEquals(10, actual.size());
    }

    @Test
    void givenTenFramesAndHasBonusBalls__ShouldReturnElevenFrameObjects() {
        BowlingGamePipeStringSplitter bowlingGamePipeStringSplitter = new BowlingGamePipeStringSplitter();

        List<BowlingFrame> actual = bowlingGamePipeStringSplitter.processGameString("X|7/|9-|X|-8|8/|-6|X|X|X||81");

        assertEquals(11, actual.size());
    }

    @Test
    void givenFrameIsStrikeShouldSetStrikeValue() {
        BowlingGamePipeStringSplitter bowlingGamePipeStringSplitter = new BowlingGamePipeStringSplitter();

        BowlingFrame actual = bowlingGamePipeStringSplitter.processGameString("X").get(0);

        assertEquals(true, actual.isStrike());
    }
}