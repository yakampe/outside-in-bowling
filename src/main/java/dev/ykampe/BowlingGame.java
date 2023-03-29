package dev.ykampe;

public class BowlingGame {
    private final BowlingGameStringSplitter bowlingGameStringSplitter;

    public BowlingGame(BowlingGameStringSplitter bowlingGameStringSplitter) {
        this.bowlingGameStringSplitter = bowlingGameStringSplitter;
    }

    public int score() {
        return 0;
    }

    public void playGame(String inputString) {
        bowlingGameStringSplitter.processGameString(inputString);
    }
}
