package dev.ykampe;

import java.util.List;

public class BowlingGame {
    private final BowlingGameStringSplitter bowlingGameStringSplitter;
    private final BowlingGameFrameCalculator bowlingGameFrameCalculator;

    public BowlingGame(BowlingGameStringSplitter bowlingGameStringSplitter, BowlingGameFrameCalculator bowlingGameFrameCalculator) {
        this.bowlingGameStringSplitter = bowlingGameStringSplitter;
        this.bowlingGameFrameCalculator = bowlingGameFrameCalculator;
    }

    public int score() {
        return 0;
    }

    public void playGame(String inputString) {
        List<BowlingFrame> bowlingFrames = bowlingGameStringSplitter.processGameString(inputString);

        bowlingFrames.forEach(bowlingFrame -> {
            bowlingGameFrameCalculator.calculateFrameScore(bowlingFrame);
        });
    }
}
