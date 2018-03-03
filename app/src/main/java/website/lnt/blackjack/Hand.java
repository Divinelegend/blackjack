package website.lnt.blackjack;

import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by Luong on 2/3/2018.
 */

public class Hand {

    LinkedList<Card> Cardinhand = new LinkedList<>();
    private int mBet;

    public int getmBet() {return mBet;}

    public void hit(Card card) {
        Cardinhand.add(card);
    }

    public int doubledown(Player p) {
        if (p.getWallet() > mBet) {
            p.setWallet(p.getWallet() - mBet);
            mBet = mBet * 2;
        } else {
            Log.e("mydebug", "You do not have enough money!");
            return -1;
        }
        return 0;
    }

    public int evalHand() {
        int pointHand = 0;
        int str = 0;
        Iterator iter = Cardinhand.iterator();
        while (iter.hasNext()) {
            Card c = (Card) iter.next();
            str = c.getNum();
            if (str > 10)
                str = 10;
            if (c.getNum() == 1)
                str = 11;
            pointHand = pointHand + str;
            if (pointHand > 21 && c.getNum() == 1)
                pointHand = pointHand - 10;
        }
        return pointHand;
    }

    public void reset() {
        Cardinhand.clear();
        mBet = 0;
    }
}
