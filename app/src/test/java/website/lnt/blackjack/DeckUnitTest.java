package website.lnt.blackjack;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Unit test for Deck class
 */
public class DeckUnitTest {
    @Test
    public void Deck_isCorrect() throws Exception {
        Deck d_1 = new Deck(1);
        assertEquals(52, d_1.getNumCards());
        assertEquals(1, d_1.getNumDecks());

        Deck d_2 = new Deck(1);
        d_2.shuffle();
        System.out.println(d_2.toString());

        boolean isShuffle = false;
        int numOfCards = d_1.getNumCards();
        for (int i = 0; i < numOfCards; i++) {
            Card c_1 = d_1.deal();
            Card c_2 = d_2.deal();
            if (!c_1.equals(c_2)) {
                isShuffle = true;
                break;
            }
        }

        assertEquals(true, isShuffle);

        isShuffle = false;
        Deck d_3 = new Deck(1);
        d_1.reset();

        numOfCards = d_1.getNumCards();
        for (int i = 0; i < numOfCards; i++) {
            Card c_1 = d_1.deal();
            Card c_2 = d_3.deal();
            if (!c_1.equals(c_2)) {
                isShuffle = true;
                break;
            }
        }

        assertEquals(false, isShuffle);
        assertEquals(0, d_1.getNumCards());

        d_1.reset(2);
        assertEquals(104, d_1.getNumCards());
    }
}
