package website.lnt.blackjack;

import android.util.Log;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Luong on 2/3/2018.
 */

public class Hand {

    ArrayList<String> Cardinhand = new ArrayList<String>();
    private int mBet;

    public void hit(String card) {
        Cardinhand.add(card);
    }

    public void doubledown() {
        if (Player.checkWallet() > mBet) {
            Player.setWallet(Player.checkWallet() - mBet);
            mBet = mBet * 2;
        } else
            Log.e("mydebug", "You do not have enough money!");
    }

    public int evalHand() {
        int pointHand = 0;
        int str = 0;
        for (int i=0; i<Cardinhand.size(); i++) {
            str = Card.getNum(Cardinhand.get(i));
            if (str > 10)
                str = 10;
            if (Card.toString(Cardinhand.get(i)) == "AceofHeart" || "AceofDiamond" || "AceofSpace" || "AceofClub")
                str = 11;
            pointHand = pointHand + str;
            if (pointHand > 21 && Card.toString(Cardinhand.get(i)) == "AceofHeart" || "AceofDiamond" || "AceofSpace" || "AceofClub")
                pointHand = pointHand - 10;
        }
        return pointHand;
    }

    public void reset() {
        Cardinhand.clear();
        mBet = 0;
    }
}
