package website.lnt.blackjack;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Unit test for Card class
 */
public class CardUnitTest {
    @Test
    public void card_isCorrect() throws Exception {
        Card c = new Card(1, Suit.CLUB);
        assertEquals(1, c.getNum());
        assertEquals(Suit.CLUB, c.getSuit());
        assertEquals("Ace of club", c.toString());

        c = new Card(2, Suit.DIAMOND);
        assertEquals(2, c.getNum());
        assertEquals(Suit.DIAMOND, c.getSuit());
        assertEquals("2 of diamond", c.toString());

        c = new Card(11, Suit.SPADE);
        assertEquals(11, c.getNum());
        assertEquals(Suit.SPADE, c.getSuit());
        assertEquals("Jack of spade", c.toString());

        try {
            c = new Card(0, Suit.HEART);
        } catch (CardException e){
            assertEquals("Invalid card num: 0", e.getMessage());
        }

        try {
            c = new Card(14, Suit.DIAMOND);
        } catch (CardException e){
            assertEquals("Invalid card num: 14", e.getMessage());
        }
    }
}
