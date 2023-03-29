package dev.ykampe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BowlingGamePipeStringSplitter {

    public List<BowlingFrame> processGameString(String gameString) {
        List<BowlingFrame> bowlingFrames = new ArrayList<>();
        Arrays.asList(gameString.split("\\|")).forEach(elem -> {
            bowlingFrames.add(new BowlingFrame());
        });
        return bowlingFrames;
    }
}
