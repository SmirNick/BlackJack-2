package com.company;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by student2 on 28.11.16.
 */

public class Table {
    public List<Player> players = new LinkedList<>();
    public Dealer dealer = new Dealer();

    public Table(int computer_amount, String[] names) {
        String[] comp_names = {"Степан", "Пётр", "Борис", "Григорий"};

        players.add(dealer);
        for (int i = 0; i < computer_amount; i++)
        {
            String name = comp_names[(int) Math.random() * comp_names.length];
            players.add(new Computer(name, new LimitIntellect(17), new HalfBetter(), 1000));
        }

        for (String name : names)
        {
            players.add(new Human(name, new ConsoleIntellect(), new HumanBetter(), 1000));
        }
    }

    public void betting()
    {
        for (Player player : players)
        {
            int bet = player.makeBet();
            System.out.println(player.name + ": " + bet);
        }
    }

    public void deal()
    {
        for (Player player : players)
        {
            dealer.deal(player);
            dealer.deal(player);
        }
    }

    public void play()
    {
        for (Player player : players) {
            while (true) {

                System.out.println(player.name + " " + player.hand.getScore() + ": " + player.hand);
                Command command = player.decision();
                //System.out.println(command);
                if (command == Command.STAND)
                    break;
                if (command == Command.HIT)
                    dealer.deal(player);
            }
        }
    }

    public void results()
    {
        for (Player player : players)
            if (player != dealer) {
                if (player.hand.getScore() > 21)
                    player.state = PlayerState.LOSS;
                else if (dealer.hand.getScore() > 21)
                    player.state = PlayerState.WIN;
                else if (dealer.hand.getScore()
                        > player.hand.getScore())
                    player.state = PlayerState.LOSS;
                else if (dealer.hand.getScore()
                        == player.hand.getScore())
                    player.state = PlayerState.DRAW;
                else
                    player.state = PlayerState.WIN;

                player.betResults();

                System.out.println(player.name + ": " + player.state + " with " + player.hand);
                System.out.println("Cash: " + player.cash);
            }
    }
}
