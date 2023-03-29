package dev.ykampe;

import java.util.List;

public class BowlingGame {
    private final BowlingGamePipeStringSplitter bowlingGameStringSplitter;
    private final BowlingGameFrameCalculator bowlingGameFrameCalculator;
    private int score;

    public BowlingGame(BowlingGamePipeStringSplitter bowlingGameStringSplitter, BowlingGameFrameCalculator bowlingGameFrameCalculator) {
        this.bowlingGameStringSplitter = bowlingGameStringSplitter;
        this.bowlingGameFrameCalculator = bowlingGameFrameCalculator;
    }

    public int score() {
        return score;
    }

    public void playGame(String inputString) {
        List<BowlingFrame> bowlingFrames = bowlingGameStringSplitter.processGameString(inputString);

        bowlingFrames.forEach(bowlingFrame -> {
           score += bowlingGameFrameCalculator.calculateFrameScore(bowlingFrame);
        });
    }
}
