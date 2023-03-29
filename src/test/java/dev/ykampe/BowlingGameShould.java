package dev.ykampe;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class BowlingGameShould {

    @Mock
    BowlingGameStringSplitter bowlingGameStringSplitter;

    @Test
    void splitIncomingStringIntoFrames() {
        BowlingGame bowlingGame = new BowlingGame(bowlingGameStringSplitter);

        bowlingGame.playGame("X|7/|9-|X|-8|8/|-6|X|X|X||81");

        Mockito.verify(bowlingGameStringSplitter).processGameString("X|7/|9-|X|-8|8/|-6|X|X|X||81");
    }

}