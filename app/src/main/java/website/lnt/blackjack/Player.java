package website.lnt.blackjack;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

class Player {
    private final long mID;
    private String mName;
    private LinkedList<Hand> mHand;
    private int mDollar;
    private static final long DEALER_ID = 0xffffL;
    private static final long MAX_PLAYER_ID = 0xfffdL;

    private long generateID() {
        Random r = new Random();

        return r.nextLong() % MAX_PLAYER_ID + 1;
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

    String getName() {
        return mName;
    }

    long getID() {
        return mID;
    }

    List<Hand> getHands() {
        return mHand;
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
        mHand.clear();
    }
}
