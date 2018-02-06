package website.lnt.blackjack;

import android.util.Log;

enum Suit {
    HEART,
    DIAMOND,
    CLUB,
    SPADE,
}

class CardException extends Exception {
    CardException(String msg, int num) {
        super(msg + ": " + num);
    }
}

class Card {
    private final int mNum;
    private final Suit mSuit;

    Card(int num, Suit suit) throws CardException {
        if (num < 1 || num > 13)
            throw new CardException("Invalid card num", num);

        mNum = num;
        mSuit = suit;
    }

    int getNum() {
        return mNum;
    }

    Suit getSuit() {
        return mSuit;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;

        if (!(o instanceof Card))
            return false;

        Card c = (Card) o;
        return c.getNum() == mNum && c.getSuit() == mSuit;
    }

    @Override
    public String toString() {
        String s;

        switch(mSuit) {
            case HEART:
                s = "heart";
                break;
            case DIAMOND:
                s = "diamond";
                break;
            case CLUB:
                s = "club";
                break;
            case SPADE:
                s = "spade";
                break;
            default:
                Log.e("Card", "Invalid suit " + mSuit);
                s = "unknown";
        }

        switch (mNum) {
            case 1:
                return "Ace of " + s;
            case 13:
                return "King of " + s;
            case 12:
                return "Queen of " + s;
            case 11:
                return "Jack of " + s;
            default:
                return "" + mNum + " of " + s;
        }
    }
}
