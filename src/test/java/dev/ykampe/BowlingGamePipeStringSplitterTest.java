package dev.ykampe;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BowlingGamePipeStringSplitterTest {

    @Test
    void givenTenFrames__ShouldReturnAListOfTenFrameObjects() {
        BowlingGamePipeStringSplitter bowlingGamePipeStringSplitter = new BowlingGamePipeStringSplitter();

        List<BowlingFrame> actual = bowlingGamePipeStringSplitter.processGameString("X|7/|9-|X|-8|8/|-6|X|X|X||81");

        assertEquals(10, actual.size());
    }
}