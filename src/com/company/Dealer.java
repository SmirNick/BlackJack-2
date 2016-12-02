package com.company;

/**
 * Created by falyanguzov on 14.11.2016.
 */
public class Dealer extends Computer {
    Deck deck = new Deck();

    public Dealer() {
        super("Dealer", new DealerIntellect(), new HalfBetter(), 0);
    }

    public void deal(Player player) {
        Card current = deck.pop();
        player.take(current);
    }
}

