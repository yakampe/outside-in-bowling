package dev.ykampe;

import java.util.List;

public interface BowlingGameStringSplitter {
    List<BowlingFrame> processGameString(String gameString);
}
