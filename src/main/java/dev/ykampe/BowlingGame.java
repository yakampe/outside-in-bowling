package dev.ykampe;

import java.util.List;

public class BowlingGame {
    private final BowlingGameStringSplitter bowlingGameStringSplitter;
    private final BowlingGameFrameCalculator bowlingGameFrameCalculator;
    private int score;

    public BowlingGame(BowlingGameStringSplitter bowlingGameStringSplitter, BowlingGameFrameCalculator bowlingGameFrameCalculator) {
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
