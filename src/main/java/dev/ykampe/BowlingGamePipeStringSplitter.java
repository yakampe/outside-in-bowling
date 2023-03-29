package dev.ykampe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BowlingGamePipeStringSplitter {

    public List<BowlingFrame> processGameString(String gameString) {
        String bonusRolls = null;
        if(gameString.contains("||")) {
            bonusRolls = gameString.substring(gameString.indexOf("||") + 2);
            gameString = gameString.substring(0,gameString.indexOf("||"));
        }

        List<BowlingFrame> bowlingFrames = new ArrayList<>();
        Arrays.asList(gameString.split("\\|")).forEach(elem -> {
            BowlingFrame bowlingFrame = new BowlingFrame();
            bowlingFrame.setRolls(elem);
            bowlingFrames.add(bowlingFrame);
        });

        if(bonusRolls != null) {
            BowlingFrame lastFrame = bowlingFrames.get(9);

            lastFrame.setRolls(lastFrame.rolls() + bonusRolls);
        }
        return bowlingFrames;
    }
}
