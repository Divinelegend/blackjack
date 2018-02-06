package website.lnt.blackjack;

import android.util.Log;

import java.util.Collections;
import java.util.LinkedList;

class Deck {
    private int mNumDecks;
    private LinkedList<Card> mDeck;

    private void addDeck() {
        try {
            for (Suit s : Suit.values())
                for (int i = 1; i < 14; i++)
                    mDeck.add(new Card(i, s));
        } catch (CardException e) {
            Log.e("Deck", e.getMessage());
        }
    }

    Deck(int num) {
        mNumDecks = num;
        mDeck = new LinkedList<>();
        reset();
    }

    int getNumDecks() {
        return mNumDecks;
    }

    int getNumCards() {
        return mDeck.size();
    }

    void shuffle() {
        Collections.shuffle(mDeck);
    }

    Card deal() {
        if (mDeck.size() == 0)
            return null;

        return mDeck.poll();
    }

    void reset() {
        mDeck.clear();
        for (int i = 0; i < mNumDecks; i++)
            addDeck();
    }

    void reset(int numDecks) {
        mNumDecks = numDecks;
        reset();
    }

    @Override
    public String toString() {
        String s = "";
        for (Card c : mDeck)
            s += c.toString() + "\n";

        return s;
    }
}
