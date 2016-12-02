package com.company;

/**
 * Created by falyanguzov on 14.11.2016.
 */
public abstract class Player {
    public Hand hand;
    private Intellect intellect;
    private Better better;

    public String name;
    public PlayerState state = PlayerState.IN_GAME;
    public int cash;


    public Player(String name, Intellect intellect, Better better, int cash) {
        this.intellect = intellect;
        this.name = name;
        this.cash = cash;
        this.better = better;
    }

    public int makeBet()
    {
        hand = new Hand();
        int bet = better.decide(cash);
        cash -= bet;
        hand.bet = bet;
        return bet;
    }

    public void take(Card current) {

        hand.add(current);
    }

    public Command decision() {

        int score = hand.getScore();
        return intellect.decide(score);

    }


    public void betResults()
    {
        if (state == PlayerState.WIN) {
            cash += 2 * hand.bet;
            hand.bet = 0;
        }

        else if (state == PlayerState.LOSS)
            hand.bet = 0;

    }
}
