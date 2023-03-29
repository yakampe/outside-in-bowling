package dev.ykampe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BowlingGamePipeStringSplitter {

    public List<BowlingFrame> processGameString(String gameString) {
        BowlingFrame bonusFrame = null;
        if(gameString.contains("||")) {
            bonusFrame = new BowlingFrame();
            gameString = gameString.substring(0,gameString.indexOf("||"));
        }


        List<BowlingFrame> bowlingFrames = new ArrayList<>();
        Arrays.asList(gameString.split("\\|")).forEach(elem -> {
            bowlingFrames.add(new BowlingFrame());
        });

        if(bonusFrame != null) {
            bowlingFrames.add(bonusFrame);
        }

        return bowlingFrames;
    }
}
