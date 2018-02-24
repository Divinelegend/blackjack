package website.lnt.blackjack;

import java.util.LinkedList;

class BlackjackException extends Exception {
    BlackjackException(String msg) {
        super(msg);
    }
}

class Blackjack {
    private LinkedList<Player> mPlayerList;
    private static Player mDealer;
    private static Deck mDeck;
    private static final int MAX_NUM_PLAYERS = 7;
    private static final int MIN_NUM_PLAYERS = 1;

    Blackjack(int numPlayers, int numDecks) {
        mPlayerList = new LinkedList<>();
        mDealer = new Player("dealer", true, 0);
        mDeck = new Deck(numDecks);
    }

    void addPlayer(Player player) throws BlackjackException {
        if (mPlayerList.size() < MAX_NUM_PLAYERS)
            mPlayerList.add(player);
        else
            throw new BlackjackException("Too many players");
    }

    void startRound() {
        for (int i = 0; i < 2; i++) {
            for (Player p : mPlayerList) {
                for (Hand h : p.getHands()) {
                    h.hit(mDeck.deal());
                }
                mDealer.getHands().get(0).hit(mDeck.deal());
            }
        }
    }

    void eval() throws BlackjackException {
        Hand dealerHand = mDealer.getHands().get(0);
        int dealerPoints = dealerHand.evalHand();

        if (mPlayerList.size() < MIN_NUM_PLAYERS)
            throw new BlackjackException("Not enough players");

        for (Player p : mPlayerList) {
            for (Hand h : p.getHands()) {
                if (dealerPoints > h.evalHand())
                    p.setWallet(p.getWallet() + (2 * h.getBet()));
                else if (dealerPoints == h.evalHand())
                    p.setWallet(p.getWallet() + h.getBet());
            }
        }
    }

    void resetRound() {
        for (Player p : mPlayerList) {
            p.resetHand();
        }
        mDeck.reset();
    }
}
