package website.lnt.blackjack;

import java.util.LinkedList;
import java.util.Random;

class Player {
    private final long mID;
    private String mName;
    private LinkedList<Card> mHand;
    private int mDollar;
    static private final long DEALER_ID = 0xffffL;

    private long generateID() {
        Random r = new Random();
        long max = 0xfffdL;

        return r.nextLong() % max + 1;
    }

    Player(String name, boolean isDealer, int dollar) {
        if (isDealer)
            mID = DEALER_ID;
        else
            mID = generateID();

        mName = name;
        mHand = new LinkedList<>();
        mDollar = dollar;
    }

    boolean isDealer() {
        return mID == DEALER_ID;
    }

    int getWallet() {
        return mDollar;
    }

    void setWallet(int dollar) {
        mDollar = dollar;
    }

    void splitHand() {
    }

    void resetHand() {
    }
}
